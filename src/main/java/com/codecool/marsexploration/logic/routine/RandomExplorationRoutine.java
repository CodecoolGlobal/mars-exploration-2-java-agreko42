package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import java.util.List;
import java.util.Random;

public class RandomExplorationRoutine implements Routine {
    @Override
    public void move(Context context, Rover rover) {
            //move rover depending on state
            Coordinate position = rover.getPosition();
            int sightRange = rover.getSightRange();
            int mapSize = context.getMap().length;
            Coordinate next = getRandomAdjacentCoordinate(position);

            while(next == position /* || iWasThereAlready(next, rover.visitedCoordinates) */ || goingOutOfBounds(next, mapSize, sightRange)){
                next = getRandomAdjacentCoordinate(position);
            }
            rover.setPosition(next);
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
