package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import javax.swing.*;
import java.util.*;

public class Scan implements Phase{
    @Override
    public void perform(Context context) {

        Coordinate currentPosition = context.rover.position;

        Set<Coordinate> surroundings = getSurroundings(currentPosition, context.rover.sightRange);

        scanSurroundings(context.map, surroundings, context.rover.interestingStuffIFound);

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
            int x = coordinate.x();
            int y = coordinate.y();
            String mapSymbol = map[x][y];
            rememberFoundStuff(interestingStuff, coordinate, mapSymbol);

        }
    }

    private void rememberFoundStuff(Map<String, Set<Coordinate>> interestingStuff, Coordinate coordinate, String mapSymbol) {
        if(interestingStuff.containsKey(mapSymbol)) {
            interestingStuff.get(mapSymbol).add(coordinate);
        }
        else {
            interestingStuff.put(mapSymbol, new HashSet<>());
            interestingStuff.get(mapSymbol).add(coordinate);
        }
        if(mapSymbol != null) {
            System.out.println("The rover found and remembered a " + mapSymbol + " at X:" + coordinate.x() + " Y:" + coordinate.y());
            System.out.println("Number of remembered " + mapSymbol + ": " + interestingStuff.get(mapSymbol).size());
        }
    }



}
