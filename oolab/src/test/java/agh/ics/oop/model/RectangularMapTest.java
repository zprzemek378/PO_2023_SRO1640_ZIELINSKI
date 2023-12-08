package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void placeMoveTest() throws PositionAlreadyOccupiedException {
        // initialize
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Animal animal1 = new Animal(new Vector2d(4,4));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal3 = new Animal(new Vector2d(4,4));
        Animal animal4 = new Animal(new Vector2d(2,2));

        Map<Vector2d, Animal> animals = new HashMap<>();
        animals.put(new Vector2d(4,4), animal1);
        animals.put(new Vector2d(2,1), animal2);
        animals.put(new Vector2d(2,2), animal4);

        //place test
        assertTrue(rectangularMap.place(animal1));
        assertTrue(rectangularMap.place(animal2));
        try {
            rectangularMap.place(animal3);
        } catch (PositionAlreadyOccupiedException e) {
            assertEquals("Position (4, 4) is already occupied", e.getMessage());
        }
        assertTrue(rectangularMap.place(animal4));

        assertEquals(animals, rectangularMap.getAnimals());

    }

    @Test
    void moveTest() {
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Animal animal1 = new Animal(new Vector2d(4,4));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal4 = new Animal(new Vector2d(2,2));

        Map<Vector2d, Animal> animals = new HashMap<>();
        animals.put(new Vector2d(4,5), animal1);
        animals.put(new Vector2d(4,1), animal2);
        animals.put(new Vector2d(2,0), animal4);



        rectangularMap.move(animal1, MoveDirection.FORWARD);
        rectangularMap.move(animal2, MoveDirection.RIGHT);
        rectangularMap.move(animal2, MoveDirection.FORWARD);
        rectangularMap.move(animal2, MoveDirection.FORWARD);
        rectangularMap.move(animal4, MoveDirection.BACKWARD);
        rectangularMap.move(animal4, MoveDirection.BACKWARD);
        rectangularMap.move(animal4, MoveDirection.BACKWARD);
        rectangularMap.move(animal4, MoveDirection.BACKWARD);
        rectangularMap.move(animal4, MoveDirection.BACKWARD);
        rectangularMap.move(animal4, MoveDirection.BACKWARD);


        //move test
        assertEquals(animals, rectangularMap.getAnimals());
    }

    @Test
    void isOccupiedTest() throws PositionAlreadyOccupiedException {
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Animal animal1 = new Animal(new Vector2d(4,4));
        Animal animal2 = new Animal(new Vector2d(2,1));

        assertFalse(rectangularMap.isOccupied(new Vector2d(4,4)));
        rectangularMap.place(animal1);
        assertTrue(rectangularMap.isOccupied(new Vector2d(4,4)));
        assertFalse(rectangularMap.isOccupied(new Vector2d(2,1)));
        rectangularMap.place(animal2);
        assertTrue(rectangularMap.isOccupied(new Vector2d(2,1)));
        assertFalse(rectangularMap.isOccupied(new Vector2d(2,2)));
    }

    @Test
    void objectAtTest() throws PositionAlreadyOccupiedException {
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Animal animal1 = new Animal(new Vector2d(4,4));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal3 = new Animal(new Vector2d(4,4));

        assertNull(rectangularMap.objectAt(new Vector2d(4, 4)));
        rectangularMap.place(animal1);
        try {
            rectangularMap.place(animal3);
        } catch (PositionAlreadyOccupiedException e) {
            assertEquals("Position (4, 4) is already occupied", e.getMessage());
        }
        assertEquals(animal1, rectangularMap.objectAt(new Vector2d(4,4)));
        assertNull(rectangularMap.objectAt(new Vector2d(3, 2)));
        rectangularMap.place(animal2);
        assertEquals(animal2, rectangularMap.objectAt(new Vector2d(2,1)));
    }
}
