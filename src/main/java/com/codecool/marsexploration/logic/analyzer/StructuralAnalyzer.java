package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;

import java.util.Map;
import java.util.Set;

public class StructuralAnalyzer implements Analyzer{
    @Override
    public void analyze(Context context, Map<String, Set<Coordinate>> stuffFound) {

        boolean enoughHousing = context.getHousings().size() >= context.getNEEDED_HOUSING();
        boolean enoughDepots = context.getDepots().size() >= context.getWANTED_NUMBER_OF_DEPOTS();

        if(enoughDepots && enoughHousing){
            context.setSimulationOutcome(Outcome.STRUCTURES_BUILT);
        }
    }
}
