package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;

public class SimulationApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
//        SimulationPresenter presenter = loader.getController();
        configureStage(primaryStage, viewRoot);
        primaryStage.show();
//        initSimulation(presenter);
    }

    public static void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }


//    private void initSimulation(SimulationPresenter presenter){
//        try {
//
//            String[] movesGrass = new String[]{
//                    "f", "f", "b", "l", "b", "f", "l", "r", "l", "r", "f", "b", "b", "r", "f", "l", "r", "b", "f", "f", "l", "r"
//            };
//            List<Vector2d> positionsGrass = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(2,11));
//
//            List<MoveDirection> directionsGrass = OptionsParser.parse(movesGrass);
//
//
//            GrassField grassField = new GrassField(10);
//
//
//            Simulation simulationGrass = new Simulation(positionsGrass, directionsGrass, grassField);
//
//
//            ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
//
//            grassField.addObserver(consoleMapDisplay);
//            grassField.addObserver(presenter);
//
//
//            SimulationEngine simulationEngine = new SimulationEngine(List.of(simulationGrass));
//            simulationEngine.runSync();
//
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//    }
}
