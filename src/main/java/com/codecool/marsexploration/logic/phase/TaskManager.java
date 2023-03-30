package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.getEverythingFound;

import java.util.*;
import java.util.stream.Collectors;


public class TaskManager implements Phase{
    @Override
    public void perform(Context context, Rover rover) {

        if(rover.getCurrentTask() != null && rover.getCurrentTask().getDuration() == 0){
            rover.setCurrentTask(null);
        }
        if(rover.getCurrentTask() == null && context.getSimulationOutcome() != null){
            setCorrectTask(context, rover);
        }
    }

    private void setCorrectTask(Context context, Rover rover) {
        Inventory inventory = rover.getInventory();
        if(context.getSimulationOutcome().equals(Outcome.COLONIZABLE)){
            if(!inventory.isFull()) {
                rover.setCurrentTask(new RoverTask(getMineralTarget(context), "Mine", 5));
            }
            else if(inventory.isFull() && context.getDepots().size() < context.getWANTED_NUMBER_OF_DEPOTS()){
                rover.setCurrentTask(new RoverTask(getRandomFreeLocation(context), "Build Depot", 2));
            }
        }
    }

    private Coordinate getRandomFreeLocation(Context context) {
        Map<String, Set<Coordinate>> allStuffFound = new getEverythingFound().get(context);
         List<Depot> depots= context.getDepots();

        Set<Coordinate> depotsSoFar = new HashSet<>();
        depots.stream()
                .peek( depot -> depotsSoFar.add(depot.getLocation()) )
                .collect(Collectors.toList());
        context.getRovers().stream()
                .filter( rover -> rover.getCurrentTask() != null)
                .filter( rover -> rover.getCurrentTask().getAction().equals("Build Depot"))
                .peek( rover -> depotsSoFar.add(rover.getCurrentTask().getTarget()))
                .collect(Collectors.toList());

        Coordinate randomFreeLocation = allStuffFound.get(null).stream()
                .filter( coordinate -> !(depotsSoFar.contains(coordinate)) )
                .findFirst()
                .get();
        return randomFreeLocation;
    }


    private Coordinate getMineralTarget(Context context) {
        Map<String, Set<Coordinate>> allStuffFound = new getEverythingFound().get(context);
        Coordinate mineralLocation = allStuffFound.get(Symbol.MINERAL.getSymbol()).stream().findAny().get();
        return mineralLocation;
    }

    //find out which task

    //instantiate task
    //add task to rover
    //delete done tasks
}
