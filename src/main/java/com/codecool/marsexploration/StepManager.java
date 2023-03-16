package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.logic.phase.Phase;

import java.util.List;

public class StepManager {
    public List<Phase> phaseList;
    public StepManager(List<Phase> phaseList) {
        this.phaseList = phaseList;
    }
    public void runAllPhases(Context context) {
        for(Phase phase : phaseList){
            phase.perform(context);
        }
    }
}
