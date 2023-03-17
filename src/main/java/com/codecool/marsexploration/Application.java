package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.logic.phase.Phase;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        long timeout = 100;
        Coordinate landingSpot = new Coordinate(12, 12);
        Rover rover = new Rover("Opportunity", landingSpot, 3);




        String[][] mapDummy = new String[100][100];
        mapDummy[8][12] = "*";
        mapDummy[16][12] = "*";
        mapDummy[12][8] = "*";
        mapDummy[12][16] = "*";
        mapDummy[16][16] = "*";
        mapDummy[8][8] = "*";
        mapDummy[16][8] = "*";
        mapDummy[8][16] = "*";

        int mineralsNeededForColonization = 3;
        int waterNeededForColonization = 2;
        Context context = new Context(timeout, mapDummy, landingSpot, rover, mineralsNeededForColonization, waterNeededForColonization);

        List<Phase> phaseList = new PhaseLoader().loadPhases();
        StepManager manager = new StepManager(phaseList);


        ExplorationSimulator simulator = new ExplorationSimulator(context, manager);

        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-1.map",
                landingSpot,
                timeout,
                "src/main/resources/exploration-1.log");

        simulator.simulate(input);
    }
}
