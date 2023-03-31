package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.*;

import java.util.Map;
import java.util.Set;

public class ReadyForColonistsAnalyzer implements Analyzer{
    @Override
    public void analyze(Context context, Map<String, Set<Coordinate>> stuffFound) {
        long numberOfNonFullDepots = context.getDepots().stream()
                .filter( depot -> !depot.isFull)
                .count();

        boolean depotsAreFull = allDepotsFull(context);
        boolean enoughDepots = context.getDepots().size() >= context.getWANTED_NUMBER_OF_DEPOTS();
        boolean enoughHousing = context.getHousings().size() >= context.getNEEDED_HOUSING();

            if(depotsAreFull && enoughDepots && enoughHousing) {
                context.setSimulationOutcome(Outcome.READY_FOR_COLONISTS);
            }

    }

    private boolean allDepotsFull(Context context) {
        for(Depot depot : context.getDepots()){
            for(Symbol key : depot.getInventory().getInventory().keySet()) {
                if(!depot.getInventory().isFull(key)){
                    return false;
                }
            }
        }
        return true;
    }
}
