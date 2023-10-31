package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    void parserTest() {
    MoveDirection[] expected = new MoveDirection[]{
            MoveDirection.FORWARD,
            MoveDirection.FORWARD,
            MoveDirection.BACKWARD,
            MoveDirection.RIGHT,
            MoveDirection.LEFT
            };

    String[] input = new String[]{"x","f", "f", "b", "o", "r", "l","k"};

    assertArrayEquals(expected, OptionsParser.parse(input));
    }
}
