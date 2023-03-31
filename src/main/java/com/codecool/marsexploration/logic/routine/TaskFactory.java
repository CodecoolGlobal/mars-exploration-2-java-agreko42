package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.getEverythingFound;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskFactory {
    public void setCorrectTaskByOutcome(Context context, Rover rover) {
        Inventory roverInventory = rover.getInventory();
        Outcome outcome = context.getSimulationOutcome();
        if(outcome == Outcome.COLONIZABLE){
            setTaskForCOLONIZABLE(context, rover, roverInventory);
        }
        else if(outcome == Outcome.STRUCTURES_BUILT){
            setTasksForSTRUCTURES_BUILT(context, rover, roverInventory);
        }
    }

    private void setTasksForSTRUCTURES_BUILT(Context context, Rover rover, Inventory roverInventory) {
        long numberOfNonFullDepots = context.getDepots().stream()
                .filter( depot -> !depot.isFull)
                .count();

        boolean allDepotsFull = allDepotsFull(context);
        if( (roverInventory.getFromInventory(Symbol.MINERAL) < roverInventory.getCapacity()) ) {
            rover.setCurrentTask(new RoverTask(getResourceTarget(context, Symbol.MINERAL.getSymbol()), Action.MINE));
        }
        else if( roverInventory.getFromInventory(Symbol.WATER) < roverInventory.getCapacity()){
            rover.setCurrentTask(new RoverTask(getResourceTarget(context, Symbol.WATER.getSymbol()), Action.GET_WATER));
        }
        else if(!allDepotsFull){
            rover.setCurrentTask(new RoverTask(getLocationOfUnfilledDepot(context), Action.FILL_DEPOT));
        }
        else{
            rover.setCurrentTask(null);
        }
    }


    private void setTaskForCOLONIZABLE(Context context, Rover rover, Inventory inventory) {
        boolean enoughDepots = context.getDepots().size() >= context.getWANTED_NUMBER_OF_DEPOTS();
        boolean enoughHousing = context.getHousings().size() >= context.getNEEDED_HOUSING();
        System.out.println("SETTING TASK ");

        if( inventory.getFromInventory(Symbol.MINERAL) < inventory.getCapacity() ) {
            System.out.println("TO MINING");
            rover.setCurrentTask(new RoverTask(getResourceTarget(context, Symbol.MINERAL.getSymbol()), Action.MINE));
        }
        else if(!enoughHousing){
            System.out.println("TO BUILDING HOUSE");
            rover.setCurrentTask(new RoverTask(getRandomFreeLocation(context), Action.BUILD_HABITAT));
        }
        else if(!enoughDepots){
            System.out.println("TO BUILDING DEPOT");
            rover.setCurrentTask(new RoverTask(getRandomFreeLocation(context), Action.BUILD_DEPOT));
        }

    }

    private boolean allDepotsFull(Context context) {
        for(Depot depot : context.getDepots()){
            if(!depot.isFull){
                return false;
            }
        }
        return true;
    }

    private Coordinate getRandomFreeLocation(Context context) {
        Map<String, Set<Coordinate>> allStuffFound = new getEverythingFound().get(context);
        List<Depot> depots= context.getDepots();
        List<Housing> housings = context.getHousings();

        Set<Coordinate> depotsSoFar = getDepotsSoFar(context, depots);
        Set<Coordinate> housingSoFar = getHousingSoFar(context, housings);

        return allStuffFound.get(null).stream()
                .filter( coordinate -> !(depotsSoFar.contains(coordinate)) )
                .filter( coordinate -> !(housingSoFar.contains(coordinate)) )
                .findFirst()
                .get();
    }

    private Coordinate getLocationOfUnfilledDepot(Context context) {
        List<Depot> depots = context.getDepots();
        Depot nonEmpty = depots.stream()
                .filter(depot -> !depot.isFull)
                .findAny()
                .get();

        return nonEmpty.getLocation();
    }
    private Set<Coordinate> getDepotsSoFar(Context context, List<Depot> depots) {
        Set<Coordinate> depotsSoFar = new HashSet<>();
        depots.stream()
                .peek( depot -> depotsSoFar.add(depot.getLocation()) )
                .collect(Collectors.toList());
        context.getRovers().stream()
                .filter( rover -> rover.getCurrentTask() != null)
                .filter( rover -> rover.getCurrentTask().getAction().equals(Action.BUILD_DEPOT))
                .peek( rover -> depotsSoFar.add(rover.getCurrentTask().getTarget()))
                .collect(Collectors.toList());
        return depotsSoFar;
    }

    private Set<Coordinate> getHousingSoFar(Context context, List<Housing> housings) {
        Set<Coordinate> housingsSoFar = new HashSet<>();
        if(housings != null){
            housings.stream()
                    .peek( housing -> housingsSoFar.add(housing.location()) )
                    .collect(Collectors.toList());
        }

        context.getRovers().stream()
                .filter( rover -> rover.getCurrentTask() != null)
                .filter( rover -> rover.getCurrentTask().getAction().equals(Action.BUILD_DEPOT))
                .peek( rover -> housingsSoFar.add(rover.getCurrentTask().getTarget()))
                .collect(Collectors.toList());
        return housingsSoFar;
    }

    private Coordinate getResourceTarget(Context context, String symbol) {
        Map<String, Set<Coordinate>> allStuffFound = new getEverythingFound().get(context);
        return allStuffFound.get(symbol).stream().findAny().get();
    }
}
