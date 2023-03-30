package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.RoverTask;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Log implements Phase{
    @Override
    public void perform(Context context, Rover rover) {
        String outputString = getOutputString(context, rover);
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

    private String getOutputString(Context context, Rover rover) {
        String stepNumber = String.valueOf(context.getStepNumber());
        String outcome = getEventString(context.getSimulationOutcome());
        String unit = rover.getId();
        String positionX = String.valueOf(rover.getPosition().x());
        String positionY = String.valueOf(rover.getPosition().y());
        String task = getTaskString(rover.getCurrentTask());

        String outputString =
                "STEP " + stepNumber + "; " +
                "UNIT " + unit + "; " +
                "POSITION " + "[" + positionX + "," + positionY + "]" + "; "+
                "CURRENT TASK: " + task + ";" +
                "CURRENT ROUTINE " + rover.getCurrentRoutine().getClass().getName() + "; " +
                "OUTCOME: " + outcome + "; " +
                """
                        
                """;
        return outputString;
    }

    private String getEventString(Outcome outcome) {
        if(outcome != null){
            return outcome.toString();
        }
        else{
            return "None yet";
        }
    }
    private String getTaskString(RoverTask task){
        if(task != null){
            return task.getAction();
        }
        else{
            return "none";
        }
    }

}
