package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        System.out.println("System wystartował");

        String[] movesGrass = new String[]{
                "f", "f", "b", "l", "b", "f", "l", "r", "l", "r", "f", "b", "b", "r", "f", "l", "r", "b", "f", "f", "l", "r"
        };
        List<Vector2d> positionsGrass = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(2,11));

        String[] movesRectangular = new String[]{
                "r", "f", "f", "l", "b", "r", "f", "r", "l", "r", "f", "r", "b", "r", "f", "f", "r", "r", "f", "f", "l", "r"
        };
        List<Vector2d> positionsRectangular = List.of(new Vector2d(2, 7), new Vector2d(1, 4), new Vector2d(6,4));

//        try {
//            List<MoveDirection> directionsGrass = OptionsParser.parse(movesGrass);
//            List<MoveDirection> directionsRectangular = OptionsParser.parse(movesRectangular);
//
//            GrassField grassField = new GrassField(10);
//            RectangularMap rectangularMap = new RectangularMap(10,10);
//
//            Simulation simulationGrass = new Simulation(positionsGrass, directionsGrass, grassField);
//            Simulation simulationRectangular = new Simulation(positionsRectangular, directionsRectangular, rectangularMap);
//
//            ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
//
//            grassField.addObserver(consoleMapDisplay);
//            rectangularMap.addObserver(consoleMapDisplay);
//
//            SimulationEngine simulationEngine = new SimulationEngine(List.of(simulationGrass, simulationRectangular));
//            simulationEngine.runAsyncInThreadPool();
//
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }

        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        List<Simulation> simulations = new ArrayList<>();
        for(int index = 0; index < 500000; index++) {

            try {
                List<MoveDirection> directionsGrass = OptionsParser.parse(movesGrass);
                List<MoveDirection> directionsRectangular = OptionsParser.parse(movesRectangular);

                GrassField grassField = new GrassField(10);
                RectangularMap rectangularMap = new RectangularMap(10,10);

                Simulation simulationGrass = new Simulation(positionsGrass, directionsGrass, grassField);
                Simulation simulationRectangular = new Simulation(positionsRectangular, directionsRectangular, rectangularMap);

                grassField.addObserver(consoleMapDisplay);
                rectangularMap.addObserver(consoleMapDisplay);

                simulations.add(simulationGrass);
                simulations.add(simulationRectangular);


            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        simulationEngine.runAsyncInThreadPool();


        System.out.println("System zakończył działanie");
    }


}
