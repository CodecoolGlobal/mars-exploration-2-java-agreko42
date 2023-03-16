package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.StepManager;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;

public class ExplorationSimulator {

    public Context context;
    public StepManager manager;

    public ExplorationSimulator(Context context, StepManager manager) {
        this.context = context;
        this.manager = manager;
    }
    public void simulate(SimulationInput input) {

        while(context.stepNumber < context.timeout){
            manager.runAllPhases(context);

        }
    }

}
