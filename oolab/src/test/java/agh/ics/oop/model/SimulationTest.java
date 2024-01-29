package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {
    @Test
    void simulationTest() {
        String[] moves = new String[]{"f", "O", "P", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"
        };
        List<MoveDirection> directions = OptionsParser.parse(moves);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(positions, directions, new RectangularMap(5,5));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();

        Vector2d expectedPosition0 = new Vector2d(2, 0);
        Vector2d expectedPosition1 = new Vector2d(3, 4);
        MapDirection expectedDirection0 = MapDirection.SOUTH;
        MapDirection expectedDirection1 = MapDirection.NORTH;

        assertEquals(expectedPosition0, animals.get(0).getPosition());
        assertEquals(expectedPosition1, animals.get(1).getPosition());
        assertEquals(expectedDirection0, animals.get(0).getAnimalDirection());
        assertEquals(expectedDirection1, animals.get(1).getAnimalDirection());
    }

    @Test
    void simulationTest2() {
        String[] moves = new String[]{
                "f", "f", "b", "l", "b", "r", "f", "o", "r", "f", "b", "b", "f", "b", "b", "f", "b", "b", "f", "b", "b", "f", "f", "r", "l"
        };
        List<MoveDirection> directions = OptionsParser.parse(moves);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(0,0));
        Simulation simulation = new Simulation(positions, directions, new RectangularMap(8,5));
        simulation.run();

        List<Animal> animals = simulation.getAnimals();

        Vector2d expectedPosition0 = new Vector2d(1, 3);
        Vector2d expectedPosition1 = new Vector2d(3, 3);
        Vector2d expectedPosition2 = new Vector2d(5, 0);
        MapDirection expectedDirection0 = MapDirection.WEST;
        MapDirection expectedDirection1 = MapDirection.SOUTH;
        MapDirection expectedDirection2 = MapDirection.NORTH;

        assertEquals(expectedPosition0, animals.get(0).getPosition());
        assertEquals(expectedPosition1, animals.get(1).getPosition());
        assertEquals(expectedPosition2, animals.get(2).getPosition());
        assertEquals(expectedDirection0, animals.get(0).getAnimalDirection());
        assertEquals(expectedDirection1, animals.get(1).getAnimalDirection());
        assertEquals(expectedDirection2, animals.get(2).getAnimalDirection());

    }
}
