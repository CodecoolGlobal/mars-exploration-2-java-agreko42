package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.*;

public class WaterFetchingRoutine implements Routine {

    public void move(Context context, Rover rover) {

        RoverTask waterFetching = rover.getCurrentTask();
        Inventory inventory = rover.getInventory();

        System.out.println(waterFetching.getDuration());
        if (waterFetching.getDuration() > 0 && !inventory.isFull(Symbol.WATER)) {
            inventory.addToInventory(Symbol.WATER, 40);
        }
        waterFetching.decreaseDuration();
        System.out.println(rover.getInventory().getFromInventory(Symbol.WATER));
    }
}
