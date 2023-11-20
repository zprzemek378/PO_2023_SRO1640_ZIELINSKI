package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextMapTest {
    @Test
    void simulationTest() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("kota");
        textMap.place("oraz");
        textMap.place("sowoniedźwiedzia");

        textMap.move("ma", MoveDirection.FORWARD);
        textMap.move("ma", MoveDirection.LEFT);
        textMap.move("ma", MoveDirection.FORWARD);
        textMap.move("ma", MoveDirection.FORWARD);

        textMap.move("Ala", MoveDirection.LEFT);
        textMap.move("Ala", MoveDirection.BACKWARD);

        textMap.move("kota", MoveDirection.LEFT);
        textMap.move("kota", MoveDirection.FORWARD);

        textMap.move("sowoniedźwiedzia", MoveDirection.LEFT);
        textMap.move("sowoniedźwiedzia", MoveDirection.BACKWARD);
        textMap.move("sowoniedźwiedzia", MoveDirection.LEFT);
        textMap.move("sowoniedźwiedzia", MoveDirection.FORWARD);


        String expectedText = "kota ma Ala oraz sowoniedźwiedzia ";

        List<StringText> expectedStringTexts = new ArrayList<>(List.of(
                new StringText("kota", MapDirection.WEST),
                new StringText("ma", MapDirection.WEST),
                new StringText("Ala", MapDirection.WEST),
                new StringText("oraz", MapDirection.NORTH),
                new StringText("sowoniedźwiedzia", MapDirection.SOUTH)
        ));

        assertEquals(expectedText, textMap.toString());
        assertEquals(expectedStringTexts, textMap.getTexts());
    }
}
