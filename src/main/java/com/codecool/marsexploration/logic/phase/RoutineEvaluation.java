package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.RoverTask;
import com.codecool.marsexploration.logic.phase.Phase;
import com.codecool.marsexploration.logic.routine.BuildingRoutine;
import com.codecool.marsexploration.logic.routine.MiningRoutine;
import com.codecool.marsexploration.logic.routine.RandomExplorationRoutine;
import com.codecool.marsexploration.logic.routine.TargetedMovementRoutine;

public class RoutineEvaluation implements Phase {
    @Override
    public void perform(Context context, Rover rover) {
        RoverTask task = rover.getCurrentTask();
        if(task == null){
            System.out.println("Task is null, setting movement to random");
            rover.setCurrentRoutine(new RandomExplorationRoutine());
        }
        else{
            boolean iAmOnTarget = onTarget(task.getTarget(), rover.getPosition());
            if(iAmOnTarget) {
                System.out.println("trying to set action-routine------------------------------------------------------");
                setAction(rover, task);
            }
            else {
                System.out.println("setting movement to targeted");
                System.out.println(" X Values:" + String.valueOf(task.getTarget().x()) + "," + String.valueOf(rover.getPosition().x()));
                System.out.println(" Y Values:" + String.valueOf(task.getTarget().y()) + "," + String.valueOf(rover.getPosition().y()));
                rover.setCurrentRoutine(new TargetedMovementRoutine());
            }
        }
    }


    private void setAction(Rover rover, RoverTask task) {

        switch(task.getAction()){
            case("Mine"):
                System.out.println("mining");
                rover.setCurrentRoutine(new MiningRoutine());
                break;

           case("Build Depot"):
               System.out.println("building");
                rover.setCurrentRoutine(new BuildingRoutine());
                break;

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
