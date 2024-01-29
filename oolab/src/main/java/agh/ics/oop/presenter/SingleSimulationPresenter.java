package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationApp;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SingleSimulationPresenter implements MapChangeListener {

    private static final int CELL_WIDTH = 30;
    private static final int CELL_HEIGHT = 30;


    private WorldMap worldMap;

    @FXML
    private Label messageLabel = new Label();
    @FXML
    private GridPane mapGrid = new GridPane();

    public void setWorldMap(WorldMap map) {
        this.worldMap = map;
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    private Label createLabel(int col, int row) {
        Label label = new Label();
        if(worldMap.objectAt(new Vector2d(row,col)) != null)
            label.setText(worldMap.objectAt(new Vector2d(row,col)).toString());
        else
            label.setText(" ");
        GridPane.setHalignment(label, HPos.CENTER);
        return label;
    }

    public void drawMap(WorldMap newMap) {
//        infoLabel.setText(newMap.toString());
        clearGrid();


        Boundary currentBounds = worldMap.getCurrentBounds();
        int bottomLeftX = currentBounds.bottomLeft().getX();
        int bottomLeftY = currentBounds.bottomLeft().getY();
        int upperRightX = currentBounds.upperRight().getX();
        int upperRightY = currentBounds.upperRight().getY();

        int diffX = upperRightX - bottomLeftX;
        int diffY = upperRightY - bottomLeftY;

//        ustawianie rozmiarów kolumny 0 i wiersza 0

        Label zeroZeroLabel = new Label();
        GridPane.setHalignment(zeroZeroLabel, HPos.CENTER);
        zeroZeroLabel.setText("y/x");

        mapGrid.add(zeroZeroLabel,0,0);

        mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));

        for (int y = 0; y <= diffY; y++) {
            Label label = new Label();
            label.setText((upperRightY - y) + "");
            mapGrid.add(label, 0, y+1);

            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
        }


        for (int x = 0; x <= diffX; x++) {
            Label label = new Label();
            label.setText((bottomLeftX + x) + "");
            mapGrid.add(label, x + 1, 0);

            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
        }

        for (int y = 0; y<=diffY; y++) {
            for (int x = 0; x<=diffX; x++) {
                Label label = createLabel(upperRightY - y, bottomLeftX + x);
                mapGrid.add(label, x + 1, y + 1);
            }
        }


    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(()-> {
            this.worldMap = worldMap;
            messageLabel.setText(message);
            drawMap(worldMap);
        });
    }
}
