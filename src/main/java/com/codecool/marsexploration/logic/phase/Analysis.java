package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.analyzer.Analyzer;

import java.util.*;
import java.util.stream.Collectors;

public class Analysis implements Phase{

    private List<Analyzer> allAnalyzer;
    public void setAllAnalyzer(List<Analyzer> allAnalyzer) {
        this.allAnalyzer = allAnalyzer;
    }
    @Override
    public void perform(Context context, Rover rover) {
        Map<String, Set<Coordinate>> allStuffFound = new HashMap<>();

        context.getRovers().stream()
                .peek(thisRover -> thisRover.getInterestingStuffIFound().keySet().stream()
                                .peek(key -> {
                                    allStuffFound.put(key, new HashSet<>());
                                    allStuffFound.get(key).addAll(thisRover.getInterestingStuffIFound().get(key));
                                })
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

  /*      for(String mapSymbol : allStuffFound.keySet()){
            System.out.println("Coordinates for " + mapSymbol + ": " );
            for(Coordinate spot : allStuffFound.get(mapSymbol)){
                System.out.println( "X" +String.valueOf(spot.x()) + " Y" + String.valueOf(spot.y()));
            }
        }*/

        for(Analyzer analyzer : allAnalyzer){
            analyzer.analyze(context, allStuffFound);
        }
    }
}
