package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Log implements Phase{
    @Override
    public void perform(Context context, Rover rover) {
        String stepNumber = String.valueOf(context.getStepNumber());
        String event = getEventString(context.getSimulationOutcome());
        String unit = rover.getId();
        String positionX = String.valueOf(rover.getPosition().x());
        String positionY = String.valueOf(rover.getPosition().y());

        String outputString =
                "STEP " + stepNumber + "; " +
                "EVENT " + event + "; " +
                "UNIT " + unit + "; " +
                "POSITION " + "[" + positionX + "," + positionY + "]" + "; "+
                "CURRENT ROUTINE " + rover.getCurrentRoutine().getClass().getName() +
                """
                        
                """;
        try {
            FileWriter filewriter = new FileWriter("src/main/resources/exploration-4.log", true);
            for(int i = 0; i < outputString.length(); i++){
                filewriter.write(outputString.charAt(i));
            }
            filewriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String getEventString(Outcome outcome) {
        if(outcome != null){
            return outcome.toString();
        }
        else{
            return "position";
        }
    }

}
