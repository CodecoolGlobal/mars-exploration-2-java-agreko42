package com.codecool.marsexploration.services;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemService {

    public Map<String, Set<Coordinate>> getFoundItemsMap(Context context){
        Map<String, Set<Coordinate>> allStuffFound = new HashMap<>();

        context.getRovers().stream()
                .peek(thisRover -> thisRover.getInterestingStuffIFound().keySet().stream()
                        .peek(key -> {
                            allStuffFound.put(key, new HashSet<>()); // TODO: avoid putting null here
                            allStuffFound.get(key).addAll(thisRover.getInterestingStuffIFound().get(key));
                        }));
//                        .collect(Collectors.toList())) eMu: diese und die nächsten Zeilen sind nicht notwendig
//                .collect(Collectors.toList());

        return allStuffFound;
    }

}
