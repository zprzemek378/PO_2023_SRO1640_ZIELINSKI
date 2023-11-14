package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {
    @Test
    void simulationTest() {
        String[] moves = new String[]{"f", "O", "P", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"
        };
        List<MoveDirection> directions = OptionsParser.parse(moves);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        List<Animal> animals = simulation.getAnimals();

        Vector2d expectedPosition0 = new Vector2d(3, 0);
        Vector2d expectedPosition1 = new Vector2d(2, 4);
        MapDirection expectedDirection0 = MapDirection.SOUTH;
        MapDirection expectedDirection1 = MapDirection.NORTH;

        assertEquals(expectedPosition0, animals.get(0).getAnimalPosition());
        assertEquals(expectedPosition1, animals.get(1).getAnimalPosition());
        assertEquals(expectedDirection0, animals.get(0).getAnimalDirection());
        assertEquals(expectedDirection1, animals.get(1).getAnimalDirection());
    }
}
