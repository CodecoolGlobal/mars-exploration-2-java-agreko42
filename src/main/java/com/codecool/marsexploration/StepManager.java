package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.phase.Phase;

import java.util.List;

public class StepManager {
    private List<Phase> phaseList;
    private Phase currentPhase;
    public StepManager(List<Phase> phaseList) {
        this.phaseList = phaseList;
        this.currentPhase = phaseList.remove(phaseList.size()-1);
    }
    public void runAllPhases(Context context, Rover rover) {
        for(Phase phase : phaseList){
            phase.perform(context, rover);
        }
    }
    public void incrementStep (Context context, Rover rover) {
        currentPhase.perform(context, rover);
    }
}
