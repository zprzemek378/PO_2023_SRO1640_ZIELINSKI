package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void equalsTest() {
        Vector2d v1 = new Vector2d(5,6);
        Vector2d v2 = new Vector2d(5,8);
        Vector2d v3 = new Vector2d(5,6);
        Vector2d v4 = new Vector2d(4,6);

        assertTrue(v1.equals(v3));
        assertFalse(v1.equals(v2));
        assertFalse(v3.equals(v4));
        assertFalse(v4.equals(v2));
    }

    @Test
    void toStringTest() {
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(5,-2);
        assertEquals("(2,3)", v1.toString());
        assertEquals("(5,-2)", v2.toString());
    }

    @Test
    void precedesFollowsTest() {
        Vector2d v1 = new Vector2d(1,3);
        Vector2d v2 = new Vector2d(7,9);
        Vector2d v3 = new Vector2d(2,4);
        Vector2d v4 = new Vector2d(10,-10);
        Vector2d v5 = new Vector2d(1,3);
        Vector2d v6 = new Vector2d(1,2);

        assertTrue(v1.precedes(v2));
        assertTrue(v1.precedes(v3));
        assertFalse(v1.precedes(v4));
        assertTrue(v1.precedes(v5));
        assertTrue(v5.precedes(v1));
        assertFalse(v1.precedes(v6));
        assertFalse(v2.precedes(v1));

        assertFalse(v1.follows(v2));
        assertTrue(v1.follows(v5));
        assertTrue(v1.follows(v6));
        assertFalse(v1.follows(v4));
    }

    @Test
    void upperRightLowerLeftTest() {
        Vector2d v1 = new Vector2d(1,3);
        Vector2d v2 = new Vector2d(7,9);
        Vector2d v3 = new Vector2d(10,9);
        Vector2d v4 = new Vector2d(10,-10);

        Vector2d resU12 = new Vector2d(7,9);
        Vector2d resU14 = new Vector2d(10,3);
        Vector2d resU23 = new Vector2d(10,9);

        Vector2d resD12 = new Vector2d(1,3);
        Vector2d resD14 = new Vector2d(1,-10);
        Vector2d resD23 = new Vector2d(7,9);


        assertEquals(resU12, v1.upperRight(v2));
        assertEquals(resU14, v1.upperRight(v4));
        assertEquals(resU23, v2.upperRight(v3));

        assertEquals(resD12, v1.lowerLeft(v2));
        assertEquals(resD14, v1.lowerLeft(v4));
        assertEquals(resD23, v2.lowerLeft(v3));
    }

    @Test
    void addSubtractTest() {
        Vector2d v1 = new Vector2d(1,3);
        Vector2d v2 = new Vector2d(7,9);
        Vector2d v3 = new Vector2d(10,-10);

        Vector2d resA12 = new Vector2d(8,12);
        Vector2d resA23 = new Vector2d(17,-1);

        Vector2d resS12 = new Vector2d(-6,-6);
        Vector2d resS32 = new Vector2d(3,-19);

        assertEquals(resA12,v1.add(v2));
        assertEquals(resA23,v2.add(v3));

        assertEquals(resS12,v1.subtract(v2));
        assertEquals(resS32,v3.subtract(v2));

    }

    @Test
    void oppositeTest() {
        Vector2d v1 = new Vector2d(7,9);
        Vector2d v2 = new Vector2d(10,-10);

        Vector2d res1 = new Vector2d(-7,-9);
        Vector2d res2 = new Vector2d(-10,10);

        assertEquals(res1, v1.opposite());
        assertEquals(res2, v2.opposite());
    }
}
