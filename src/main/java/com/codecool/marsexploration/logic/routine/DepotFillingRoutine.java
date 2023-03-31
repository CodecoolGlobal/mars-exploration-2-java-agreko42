package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.*;

public class DepotFillingRoutine implements Routine {

    @Override
    public void move(Context context, Rover rover) {
        RoverTask task = rover.getCurrentTask();
        Inventory roverInventory = rover.getInventory();
        Inventory depot = context.getDepots().stream()
                .filter( theDepot -> theDepot.getLocation() == rover.getCurrentTask().getTarget())
                .findFirst().get().getInventory();


        depot.addToInventory(Symbol.MINERAL, roverInventory.getFromInventory(Symbol.MINERAL));
        roverInventory.addToInventory(Symbol.MINERAL, 0-(roverInventory.getFromInventory(Symbol.MINERAL)) );

        depot.addToInventory(Symbol.WATER, roverInventory.getFromInventory(Symbol.WATER));
        roverInventory.addToInventory(Symbol.WATER, 0-(roverInventory.getFromInventory(Symbol.MINERAL)) );

        task.decreaseDuration();

        System.out.println(depot.getFromInventory(Symbol.MINERAL));
        System.out.println(depot.getFromInventory(Symbol.WATER));
    }
}
