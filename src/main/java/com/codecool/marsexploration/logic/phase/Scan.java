package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import javax.swing.*;
import java.util.*;

public class Scan implements Phase{
    @Override
    public void perform(Context context, Rover rover) {

        Coordinate currentPosition = rover.getPosition();

        Set<Coordinate> surroundings = getSurroundings(currentPosition, rover.getSightRange());

        scanSurroundings(context.getMap(), surroundings, rover.getInterestingStuffIFound());

    }

    private Set<Coordinate> getSurroundings(Coordinate currentPosition, int sightRange){
        Set<Coordinate> surroundings = new HashSet<>();

        int currentX = currentPosition.x();
        int currentY = currentPosition.y();

        for(int i=1; i <= sightRange; i++){
            //horizontal sight
            surroundings.add(new Coordinate(currentX +i, currentY));
            surroundings.add(new Coordinate(currentX -i, currentY));
            //vertical sight
            surroundings.add(new Coordinate(currentX, currentY + i));
            surroundings.add(new Coordinate(currentX, currentY - i));
            //right upper corner sight
            surroundings.add(new Coordinate(currentX + ( sightRange - i), currentY + i));
            // right lower corner
            surroundings.add(new Coordinate(currentX + ( sightRange - i), currentY - i));
            //left upper corner
            surroundings.add(new Coordinate(currentX - (sightRange - i), currentY + i));
            //left lower corner
            surroundings.add(new Coordinate(currentX - (sightRange - i), currentY -i));

        }
        return surroundings;
    }

    private void scanSurroundings (String[][] map, Set<Coordinate> surroundings, Map<String,Set<Coordinate>> interestingStuff) {

        for(Coordinate coordinate: surroundings) {
            int x = correctValueIntoBounds(map.length, coordinate.x());
            int y = correctValueIntoBounds(map.length, coordinate.y());
            String mapSymbol = map[x][y];

            rememberFoundStuff(interestingStuff, coordinate, mapSymbol);

        }
    }

    private int correctValueIntoBounds(int max, int value) {
        if(value < 0){
            value = 0;
        }
        else if (value >= max){
           value = max;
        }
        return value;
    }

    private void rememberFoundStuff(Map<String, Set<Coordinate>> interestingStuff, Coordinate coordinate, String mapSymbol) {
        if(interestingStuff.containsKey(mapSymbol)) {
            interestingStuff.get(mapSymbol).add(coordinate);
        }
        else {
            interestingStuff.put(mapSymbol, new HashSet<>());
            interestingStuff.get(mapSymbol).add(coordinate);
        }
    }
}
