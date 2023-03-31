package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.*;

public class BuildDepotRoutine implements Routine {
    @Override
    public void move(Context context, Rover rover) {
        RoverTask task = rover.getCurrentTask();

        if(task.getDuration() == 1){
            String id = "Depot " + (context.getDepots().size() +1);
            Coordinate location = task.getTarget();
            rover.getInventory().addToInventory(Symbol.MINERAL, -50);
            context.getDepots().add(new Depot(id, location, new Inventory(1000)));
            System.out.println("DEPOT BUILT!!!");
        }
        task.decreaseDuration();
        System.out.println("Action: " + task.getAction());
        System.out.println("At: " + "X " + task.getTarget().x() + "  Y " + task.getTarget().y());
    }
}
