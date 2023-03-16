package com.codecool.marsexploration.data;

import com.codecool.marsexploration.logic.routine.Routine;

import java.util.*;

public class Rover {
    public String id;




    public Coordinate position;
    public int sightRange;
    public Routine currentRoutine;
    public Map<String, Set<Coordinate>> interestingStuffIFound;
    public List<Coordinate> visitedCoordinates;

    public Rover(String id, Coordinate position, int sightRange) {
        this.id = id;
        this.position = position;
        this.sightRange = sightRange;
        this.interestingStuffIFound = new HashMap<String, Set<Coordinate>>();
        visitedCoordinates = new ArrayList<>();
        visitedCoordinates.add(position);
    }

    public void setPosition(Coordinate position) {
        visitedCoordinates.add(position);
        this.position = position;
    }

}
