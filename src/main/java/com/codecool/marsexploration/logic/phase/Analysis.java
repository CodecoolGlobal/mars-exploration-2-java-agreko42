package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.getEverythingFound;

import java.util.*;
import java.util.stream.Collectors;

public class Analysis implements Phase{

    private List<Analyzer> allAnalyzer;
    public void setAllAnalyzer(List<Analyzer> allAnalyzer) {
        this.allAnalyzer = allAnalyzer;
    }
    @Override
    public void perform(Context context, Rover rover) {

  /*      for(String mapSymbol : allStuffFound.keySet()){
            System.out.println("Coordinates for " + mapSymbol + ": " );
            for(Coordinate spot : allStuffFound.get(mapSymbol)){
                System.out.println( "X" +String.valueOf(spot.x()) + " Y" + String.valueOf(spot.y()));
            }
        }*/

        Map<String, Set<Coordinate>> allStuffFound = new getEverythingFound().get(context);
        for(Analyzer analyzer : allAnalyzer){
            analyzer.analyze(context, allStuffFound);
        }
    }
}
