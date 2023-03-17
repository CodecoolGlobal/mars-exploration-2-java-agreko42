package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ColonizabilityAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
/*        boolean isColonizable ()  {
            Map<String, Set<Coordinate>> stuff = context.rover.interestingStuffIFound;
            for(String mapSymbol : stuff.keySet()){
                stuff.get(mapSymbol).size()
            }
        }*/
        Map<String, Set<Coordinate>> stuff = context.rover.interestingStuffIFound;
        boolean isColonizable =
                stuff.get(Symbol.MINERAL.getSymbol()).size() >= context.MINERALS_NEEDED_FOR_COLONIZATION
                && stuff.get(Symbol.WATER.getSymbol()).size() >= context.WATER_NEEDED_FOR_COLONIZATION
                && stuff.get(Symbol.ALIEN.getSymbol()).size() == 0;
        if(isColonizable){
            return Optional.of(Outcome.COLONIZABLE);
        }
        else{return null;
        }
    }
}
