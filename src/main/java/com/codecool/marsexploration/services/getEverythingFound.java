package com.codecool.marsexploration.services;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class getEverythingFound {

    public Map<String, Set<Coordinate>> get(Context context){
        Map<String, Set<Coordinate>> allStuffFound = new HashMap<>();

        context.getRovers().stream()
                .peek(thisRover -> thisRover.getInterestingStuffIFound().keySet().stream()
                        .peek(key -> {
                            allStuffFound.put(key, new HashSet<>());
                            allStuffFound.get(key).addAll(thisRover.getInterestingStuffIFound().get(key));
                        })
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return allStuffFound;
    }

}
