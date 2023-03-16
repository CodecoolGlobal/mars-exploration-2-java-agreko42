package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import java.util.List;
import java.util.Random;

public class Movement implements Phase{

    @Override
    public void perform(Context context) {
        //move rover depending on state
        Rover rover = context.rover;
        Coordinate position = rover.position;
        int sightRange = rover.sightRange;
        int mapSize = context.map.length;
        
        Coordinate next = getRandomAdjacentCoordinate(position);
        while(next == position /* || iWasThereAlready(next, rover.visitedCoordinates) */ || goingOutOfBounds(next, mapSize, sightRange)){
            next = getRandomAdjacentCoordinate(position);
        }
        rover.setPosition(next);
        System.out.println("Rover moves to X:"+ next.x() + " Y:" + next.y());
    }

    private Coordinate getRandomAdjacentCoordinate (Coordinate currentPosition) {
        int[] options = new int[]{-1,1,0};
        Random randomChoice = new Random();
        
        int newX = currentPosition.x() + options[randomChoice.nextInt(options.length)];
        int newY = currentPosition.y() + options[randomChoice.nextInt(options.length)];
        
        return new Coordinate(newX, newY);
    }

    private boolean iWasThereAlready(Coordinate next, List<Coordinate> pastPositions) {
        return pastPositions.contains(next);
    }

    private boolean goingOutOfBounds(Coordinate next, int mapSize, int sightRange) {
        boolean xOutOfBounds = next.x() - sightRange < 0 || next.x() + sightRange >= mapSize;
        boolean yOutOfBounds = next.y() - sightRange < 0 || next.y() + sightRange >= mapSize;


        return xOutOfBounds || yOutOfBounds;
    }
}
