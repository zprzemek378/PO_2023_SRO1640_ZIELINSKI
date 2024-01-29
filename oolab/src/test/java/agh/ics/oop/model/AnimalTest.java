package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    void Test() {
        // test pierwszego konstruktora
        Animal animal1 = new Animal();
        assertEquals(new Vector2d(2, 2), animal1.getPosition());
        assertEquals(MapDirection.NORTH, animal1.getAnimalDirection());


        // test drugiegokonstruktora
        Animal animal2 = new Animal(new Vector2d(3, 7));
        assertEquals(new Vector2d(3, 7), animal2.getPosition());
        assertEquals(MapDirection.NORTH, animal2.getAnimalDirection());


        Animal animal3 = new Animal(new Vector2d(3, 7));
        RectangularMap rectangularMap = new RectangularMap(10,10);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.RIGHT, rectangularMap);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.RIGHT, rectangularMap);
        animal3.move(MoveDirection.BACKWARD, rectangularMap);
        animal3.move(MoveDirection.FORWARD, rectangularMap);
        animal3.move(MoveDirection.LEFT, rectangularMap);

        assertEquals(new Vector2d(5, 8), animal3.getPosition());
        assertEquals(MapDirection.EAST, animal3.getAnimalDirection());

        //toString
        assertEquals("N", animal1.toString());
        assertEquals("E", animal3.toString());
    }
}
