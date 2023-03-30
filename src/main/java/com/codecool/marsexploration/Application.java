package com.codecool.marsexploration;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.logic.phase.Phase;
import com.codecool.marsexploration.logic.routine.RandomExplorationRoutine;
import com.codecool.marsexploration.logic.routine.Routine;
import com.codecool.marsexploration.logic.routine.TargetedMovementRoutine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        long timeout = 600;
        Coordinate landingSpot = new Coordinate(12, 12);
        Routine startingRoutine = new RandomExplorationRoutine();
        List<Rover> startingRovers = new ArrayList<>();
        Rover opportunity = new Rover("Opportunity", landingSpot, 3, startingRoutine);
        startingRovers.add(opportunity);

        Routine targetRoutine = new TargetedMovementRoutine();
        startingRovers.add(new Rover("roverlyDope", landingSpot, 3, startingRoutine));

        String[][] mapDummy = new String[100][100];
        mapDummy[8][12] = "*";
        mapDummy[16][12] = "~";
        mapDummy[12][8] = "*";
        mapDummy[12][16] = "~";
        mapDummy[16][16] = "*";
        mapDummy[8][8] = "~";
        mapDummy[16][8] = "*";
        mapDummy[8][16] = "~";

        int mineralsNeededForColonization = 3;
        int waterNeededForColonization = 2;
        int wantedNumberOfDepots = 2;
        Context context = new Context(timeout, mapDummy, landingSpot, startingRovers, mineralsNeededForColonization, waterNeededForColonization, wantedNumberOfDepots);


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
