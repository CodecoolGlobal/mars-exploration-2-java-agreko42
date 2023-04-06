package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

public class TargetedMovementRoutine implements Routine{
    @Override
    public void move(Context context, Rover rover) {
        Coordinate target = rover.getCurrentTask().getTarget();
        int currentX = rover.getPosition().x();
        int currentY = rover.getPosition().y();
        int targetX = target.x();
        int targetY = target.y();
        if(targetX != currentX || targetY != currentY) {
            Coordinate nextPosition = new Coordinate(
                    correctThisPosition(targetX, currentX),
                    correctThisPosition(targetY, currentY)
            );
            rover.setPosition(nextPosition);
        }
    }
    public int correctThisPosition(int target, int current ){
        if(current > target){
            current -= 1;
        }
        else if(current < target) {
            current += 1;
        }
        return current;
    }
}
