package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {


    @Test
    void placeMoveTest() {
        // initialize
        GrassField grassField = new GrassField(4);
        Animal animal1 = new Animal(new Vector2d(4,4));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal3 = new Animal(new Vector2d(4,4));
        Animal animal4 = new Animal(new Vector2d(2,2));

        Map<Vector2d, Animal> animals = new HashMap<>();
        animals.put(new Vector2d(4,4), animal1);
        animals.put(new Vector2d(2,1), animal2);
        animals.put(new Vector2d(2,2), animal4);

        //place test
        assertTrue(grassField.place(animal1));
        assertTrue(grassField.place(animal2));
        assertFalse(grassField.place(animal3));
        assertTrue(grassField.place(animal4));

        assertEquals(animals, grassField.getAnimals());

    }

    @Test
    void moveTest() {
        GrassField grassField = new GrassField(4);
        Animal animal1 = new Animal(new Vector2d(4,4));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal4 = new Animal(new Vector2d(2,2));

        Map<Vector2d, Animal> animals = new HashMap<>();
        animals.put(new Vector2d(4,5), animal1);
        animals.put(new Vector2d(4,1), animal2);
        animals.put(new Vector2d(2,0), animal4);



        grassField.move(animal1, MoveDirection.FORWARD);
        grassField.move(animal2, MoveDirection.RIGHT);
        grassField.move(animal2, MoveDirection.FORWARD);
        grassField.move(animal2, MoveDirection.FORWARD);
        grassField.move(animal4, MoveDirection.BACKWARD);
        grassField.move(animal4, MoveDirection.BACKWARD);


        //move test
        assertEquals(animals, grassField.getAnimals());
    }

    @Test
    void isOccupiedTest() {
        GrassField grassField = new GrassField(4);
        Animal animal1 = new Animal(new Vector2d(4,4));
        Animal animal2 = new Animal(new Vector2d(2,1));

        grassField.place(animal1);
        assertTrue(grassField.isOccupied(new Vector2d(4,4)));
        grassField.place(animal2);
        assertTrue(grassField.isOccupied(new Vector2d(2,1)));

        // nie da się zrobić testu dla obecności trawy, gdyż za każdym razem jest ona generowana w innych miejscach
    }

    @Test
    void objectAtTest() {
        GrassField grassField = new GrassField(4);
        Animal animal1 = new Animal(new Vector2d(4,4));
        Animal animal2 = new Animal(new Vector2d(2,1));
        Animal animal3 = new Animal(new Vector2d(4,4));

        grassField.place(animal1);
        grassField.place(animal3);
        assertEquals(animal1, grassField.objectAt(new Vector2d(4,4)));
        grassField.place(animal2);
        assertEquals(animal2, grassField.objectAt(new Vector2d(2,1)));
    }
}
