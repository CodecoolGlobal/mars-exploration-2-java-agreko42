package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.*;

public class BuildHousingRoutine implements Routine {
    @Override
    public void move(Context context, Rover rover) {
        RoverTask task = rover.getCurrentTask();

        if(task.getDuration() == 1){
            String id = "Habitat " + (context.getHousings().size() +1);
            Coordinate location = task.getTarget();
            rover.getInventory().addToInventory(Symbol.MINERAL, -30);
            context.getHousings().add(new Housing(id,6, rover.getId(), location));
            System.out.println("HABITAT BUILT!!!");
        }
        task.decreaseDuration();
    }
}

