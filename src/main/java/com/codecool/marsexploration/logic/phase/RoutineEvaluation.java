package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.routine.*;

public class RoutineEvaluation implements Phase {
    private final RoutineFactory actions;

    public RoutineEvaluation(RoutineFactory actions) {
        this.actions = actions;
    }
    @Override
    public void perform(Context context, Rover rover) {
        RoverTask task = rover.getCurrentTask();
        if(task == null){
            actions.setAction(rover, Action.EXPLORE);
        }
        else{
            boolean iAmOnTarget = onTarget(task.getTarget(), rover.getPosition());
            if(iAmOnTarget) {
                actions.setAction(rover, task.getAction());
            }
            else {
                actions.setAction(rover, Action.GO_TO_TARGET);

                System.out.println(" TargetX: " + String.valueOf(task.getTarget().x()) + ";;; Current: " + String.valueOf(rover.getPosition().x()));
                System.out.println(" TargetY: " + String.valueOf(task.getTarget().y()) + ";;; Current: " + String.valueOf(rover.getPosition().y()));
            }
        }
    }
    private boolean onTarget(Coordinate target, Coordinate currentPosition){
        int targetX = target.x();
        int targetY = target.y();
        int currentX = currentPosition.x();
        int currentY = currentPosition.y();
        return targetX == currentX && targetY == currentY;
    }
}
