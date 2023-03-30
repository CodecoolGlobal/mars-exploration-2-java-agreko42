package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.*;

public class MiningRoutine implements Routine{
    @Override
    public void move(Context context, Rover rover) {

        RoverTask mining = rover.getCurrentTask();
        Inventory inventory = rover.getInventory();

        System.out.println(mining.getDuration());
        if(mining.getDuration() > 0 && !inventory.isFull()){
            inventory.addToInventory(Symbol.MINERAL, 40);
            System.out.println(mining.getDuration());
        }
        mining.decreaseDuration();
        System.out.println(rover.getInventory().getFromInventory(Symbol.MINERAL));
    }
}
