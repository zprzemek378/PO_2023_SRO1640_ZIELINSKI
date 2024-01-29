package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationApp;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class SimulationPresenter {


    @FXML
    private TextField moveList = new TextField();
    @FXML
    private Label messageLabel = new Label();




    public void startNewWindow(String[] moves) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("singleSimulation.fxml"));
        BorderPane viewRoot = loader.load();

        SingleSimulationPresenter additionalPresenter = loader.getController();

        Stage additionalStage = new Stage();

        SimulationApp.configureStage(additionalStage, viewRoot);
        additionalStage.show();
        initSimulation(additionalPresenter, moves);
    }

    public void onSimulationStartClicked() throws IOException {
        String[] moves =  moveList.getText().split(" ");
        moveList.setText("");

        startNewWindow(moves);
    }


    private void initSimulation(SingleSimulationPresenter presenter, String[] movesGrass) {
        try {
            List<Vector2d> positionsGrass = List.of(new Vector2d(2, 2), new Vector2d(1, 1));

            List<MoveDirection> directionsGrass = OptionsParser.parse(movesGrass);


            GrassField grassField = new GrassField(10);


            Simulation simulationGrass = new Simulation(positionsGrass, directionsGrass, grassField);
            grassField.addObserver(presenter);

            grassField.addObserver(new ConsoleMapDisplay());


            SimulationEngine simulationEngine = new SimulationEngine(List.of(simulationGrass));
            simulationEngine.runAsyncInThreadPool();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
