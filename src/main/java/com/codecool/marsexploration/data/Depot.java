package com.codecool.marsexploration.data;

import java.util.HashMap;
import java.util.Map;

public class Depot {
    //TODO: change access modifier
    public String id;
    public Coordinate location;
    public boolean isFull;
    public Inventory inventory;

    public Depot(String id, Coordinate location, Inventory inventory) {
        this.id = id;
        this.location = location;
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public Coordinate getLocation() {
        return location;
    }

}
