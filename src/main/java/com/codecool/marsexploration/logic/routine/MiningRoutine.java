package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.*;

public class MiningRoutine implements Routine{
    @Override
    public void move(Context context, Rover rover) {

        RoverTask mining = rover.getCurrentTask();
        Inventory inventory = rover.getInventory();

        if(mining.getDuration() > 0 && !inventory.isFull(Symbol.MINERAL)){
            inventory.addToInventory(Symbol.MINERAL, 40);
        }
        mining.decreaseDuration();
    }
}
