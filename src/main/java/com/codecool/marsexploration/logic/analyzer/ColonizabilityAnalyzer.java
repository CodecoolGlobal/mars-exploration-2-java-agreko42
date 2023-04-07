package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;

import java.util.Map;
import java.util.Set;

public class ColonizabilityAnalyzer implements Analyzer{
    @Override
    public void analyze(Context context, Map<String, Set<Coordinate>> stuffFound) {
        if(isColonizable(context, stuffFound)){
            context.setSimulationOutcome(Outcome.COLONIZABLE);
        }
    }
    private boolean isColonizable (Context context, Map<String, Set<Coordinate>> stuffFound)  {
        boolean enoughMinerals = false;
        boolean enoughWater = false;

        for(String mapSymbol : stuffFound.keySet()) {
            if( mapSymbol != null && mapSymbol.equals(Symbol.MINERAL.getSymbol()) ) {
                enoughMinerals = stuffFound.get(mapSymbol).size() >= context.getMineralsNeeded();
            }
            if (mapSymbol != null && mapSymbol.equals(Symbol.WATER.getSymbol())) {
                enoughWater = stuffFound.get(mapSymbol).size() >= context.getWaterNeeded();
            }
        }
        return enoughMinerals && enoughWater;
    }

}
