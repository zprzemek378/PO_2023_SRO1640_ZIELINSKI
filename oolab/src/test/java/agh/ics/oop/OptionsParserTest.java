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

    String[] input = new String[]{"f", "f", "b", "r", "l"};

    assertEquals(expected, OptionsParser.parse(input));
    }

    @Test
    void parserTest2() {
        List<MoveDirection> expected = new ArrayList<>(List.of(
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        ));

        String[] input = new String[]{"f", "o", "f", "b", "r", "x", "l"};

        try {
            OptionsParser.parse(input);
        }
        catch (IllegalArgumentException e) {
            assertEquals("\"o\" is not legal move specification", e.getMessage());
        }
    }

    @Test
    void parserTest3() {
        List<MoveDirection> expected = new ArrayList<>(List.of(
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        ));

        String[] input = new String[]{"xggg","f", "f", "b", "ff", "r", "l","k"};

        try {
            OptionsParser.parse(input);
        }
        catch (IllegalArgumentException e) {
            assertEquals("\"xggg\" is not legal move specification", e.getMessage());
        }
    }

    @Test
    void parserTest4() {
        List<MoveDirection> expected = new ArrayList<>(List.of());

        String[] input = new String[]{};

        assertEquals(expected, OptionsParser.parse(input));
    }
}
