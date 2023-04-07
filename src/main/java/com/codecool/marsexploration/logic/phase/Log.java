package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.*;

import java.io.FileWriter;
import java.io.IOException;


public class Log implements Phase{
    @Override
    public void perform(Context context, Rover rover) {
        String outputString = getOutputString(context, rover);
        try(FileWriter filewriter = new FileWriter("src/main/resources/exploration-5.log", true)) {
            for(int i = 0; i < outputString.length(); i++){
                filewriter.write(outputString.charAt(i));
            }
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
        String numberOfDepots = String.valueOf(context.getDepots().size());
        String numberOfHouses = String.valueOf(context.getHousings().size());

        String outputString = String.format(
                "STEP %s; UNIT %s; POSITION " + "[%s,%s]; CURRENT TASK: %s; OUTCOME: %s; DEPOTS: %s; Houses: %s; " +
                """
                        
                """,
                stepNumber,
                unit,
                positionX,
                positionY,
                task,
                outcome,
                numberOfDepots,
                numberOfHouses);

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
            return task.getAction().toString();
        }
        else{
            return "none";
        }
    }

}
