package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    void parserTest() {
    List<MoveDirection> expected = new ArrayList<>(List.of(
            MoveDirection.FORWARD,
            MoveDirection.FORWARD,
            MoveDirection.BACKWARD,
            MoveDirection.RIGHT,
            MoveDirection.LEFT
    ));

    String[] input = new String[]{"x","f", "f", "b", "o", "r", "l","k"};

    assertEquals(expected, OptionsParser.parse(input));
    }
}
