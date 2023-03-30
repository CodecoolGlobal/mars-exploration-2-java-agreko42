package com.codecool.marsexploration.data;

import java.util.HashMap;
import java.util.Map;

public class Depot {
    public String id;
    public Coordinate location;
    public boolean isFull;
    public Map<String, Integer> resourcesOnStock;

    public Depot(String id, Coordinate location, boolean isFull) {
        this.id = id;
        this.location = location;
        this.isFull = isFull;
        this.resourcesOnStock = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public Coordinate getLocation() {
        return location;
    }
    public Map<String, Integer> getResourcesOnStock() {
        return resourcesOnStock;
    }
    public void setResourcesOnStock(Map<String, Integer> resourcesOnStock) {
        this.resourcesOnStock = resourcesOnStock;
    }
}
