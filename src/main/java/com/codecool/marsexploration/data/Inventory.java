package com.codecool.marsexploration.data;

import java.util.HashMap;
import java.util.Map;

public class Inventory {



    private Map<Symbol, Integer> inventory;
    private final int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        this.inventory = new HashMap<>();
    }

    public void addToInventory(Symbol symbol, Integer amount) {
       if(inventory.containsKey(symbol)){
            inventory.put(symbol, inventory.get(symbol) + amount);
            limitToCapacity(symbol);
       }
       else{
           inventory.put(symbol, amount);
           limitToCapacity(symbol);
       }
    }
    public int getCapacity() {
        return capacity;
    }
    public int getFromInventory(Symbol symbol) {
        if(inventory.get(symbol) != null){
            return inventory.get(symbol);
        }
        else{ return 0; }
    }
    public Map<Symbol, Integer> getInventory() {
        return inventory;
    }
    public boolean isFull(Symbol symbol) {
        boolean isFull = false;
        if(inventory.get(symbol) != null) {
            isFull = inventory.get(symbol) == capacity;
        }

        return isFull;
    }
    private void limitToCapacity(Symbol symbol){
        if(inventory.get(symbol) >= capacity){
            inventory.put(symbol, capacity);
        }
        else if(inventory.get(symbol) <= 0 ){
            inventory.put(symbol, 0);
        }
    }
    private int getInventoryCount(){
        return inventory.keySet().stream()
                .map( symbol -> inventory.get(symbol) )
                .reduce(0, (sum, nextValue) -> sum + nextValue);
    }
}
