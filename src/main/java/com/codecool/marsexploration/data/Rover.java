package com.codecool.marsexploration.data;

import com.codecool.marsexploration.logic.routine.Routine;

import java.util.*;

public class Rover {
    private String id;
    private Coordinate position;
    private int sightRange;
    private Routine currentRoutine;
    private Map<String, Set<Coordinate>> interestingStuffIFound;
    private List<Coordinate> visitedCoordinates;
    private RoverTask currentTask;
    private Inventory inventory;


    public Rover(String id, Coordinate position, int sightRange, Routine currentRoutine) {
        this.id = id;
        this.position = position;
        this.sightRange = sightRange;
        this.currentRoutine = currentRoutine;
        this.inventory = new Inventory();
        this.interestingStuffIFound = new HashMap<>();
        this.visitedCoordinates = new ArrayList<>();
        visitedCoordinates.add(position);
    }

    public void setPosition(Coordinate position) {
        visitedCoordinates.add(position);
        this.position = position;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Coordinate getPosition() {
        return position;
    }
    public int getSightRange() {
        return sightRange;
    }
    public Routine getCurrentRoutine() {
        return currentRoutine;
    }
    public void setCurrentRoutine(Routine currentRoutine) {
        this.currentRoutine = currentRoutine;
    }
    public Map<String, Set<Coordinate>> getInterestingStuffIFound() {
        return interestingStuffIFound;
    }
    public void setInterestingStuffIFound(Map<String, Set<Coordinate>> interestingStuffIFound) {
        this.interestingStuffIFound = interestingStuffIFound;
    }
    public List<Coordinate> getVisitedCoordinates() {
        return visitedCoordinates;
    }
    public void setVisitedCoordinates(List<Coordinate> visitedCoordinates) {
        this.visitedCoordinates = visitedCoordinates;
    }
    public RoverTask getCurrentTask() {
        return currentTask;
    }
    public void setCurrentTask(RoverTask currentTask) {
        this.currentTask = currentTask;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
