package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.StepManager;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.SimulationInput;

import java.util.stream.Collectors;

public class ExplorationSimulator {

    public Context context;
    public StepManager manager;

    public ExplorationSimulator(Context context, StepManager manager) {
        this.context = context;
        this.manager = manager;
    }
    public void simulate(SimulationInput input) {

        while(context.getStepNumber() < context.getTimeout() || context.getSimulationOutcome() != context.getWANTED_OUTCOME()){
            System.out.println(context.getStepNumber() + " ---------------------- ---------------- --------------");
            context.getRovers().stream()
                            .peek(currentRover -> manager.runAllPhases(context, currentRover))
                    .collect(Collectors.toList());
            manager.incrementStep(context, context.getRovers().get(0));
        }
    }

}
