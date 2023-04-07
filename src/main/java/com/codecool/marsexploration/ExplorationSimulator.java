package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
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

        // eMu: ich habe übrigens noch einmal nachgelesen - du hattest Recht, bei enums kann man auch == verwenden
        while(context.getStepNumber() < context.getTimeout() || context.getSimulationOutcome() != context.getWantedOutcome()){
            context.getRovers().stream()
                            .peek(currentRover -> manager.runAllPhases(context, currentRover));
                    //.collect(Collectors.toList()); -- eMu: die Zeile macht wenig Sinn, weil du mit der Liste nichts machst
            manager.incrementStep(context, context.getRovers().get(0));
        }
    }

}
