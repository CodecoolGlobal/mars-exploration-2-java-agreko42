package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.RoverTask;
import com.codecool.marsexploration.logic.phase.Phase;
import com.codecool.marsexploration.logic.routine.RandomExplorationRoutine;
import com.codecool.marsexploration.logic.routine.TargetedMovementRoutine;

public class RoutineEvaluation implements Phase {
    @Override
    public void perform(Context context, Rover rover) {
        RoverTask task = rover.getCurrentTask();
        if(task != null && task.getTarget() != rover.getPosition()){
            System.out.println("setting movement to targeted");
            System.out.println(" X Values:" + String.valueOf(task.getTarget().x()) + "," + String.valueOf(rover.getPosition().x()));
            System.out.println(" Y Values:" + String.valueOf(task.getTarget().y()) + "," + String.valueOf(rover.getPosition().y()));
            rover.setCurrentRoutine(new TargetedMovementRoutine());
        }
        else if(task != null && task.getTarget().x() == rover.getPosition().x() && task.getTarget().y() == rover.getPosition().y()){
            System.out.println("trying to set action-routine------------------------------------------------------");
            setAction(rover, task);
        }
        else if(task == null){
            System.out.println("setting movement to random");
            rover.setCurrentRoutine(new RandomExplorationRoutine());
        }
    }

    private void setAction(Rover rover, RoverTask task) {

        switch(task.getAction()){
            case(""):
                rover.setCurrentRoutine(new RandomExplorationRoutine());
                rover.setCurrentTask(null);
                break;
                /*
            case("Mining"):
                rover.setCurrentRoutine(new MiningRoutine());
                break;
            case("Building"):
                rover.setCurrentRoutine(new BuildingRoutine());
                break;
                */
        }
    }
}
