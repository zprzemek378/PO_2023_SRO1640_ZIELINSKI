package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsParser {
//    private static MoveDirection[] append(MoveDirection[] before, MoveDirection newElement) {
//        MoveDirection[] after = new MoveDirection[before.length+1];
//        after = Arrays.copyOf(before, before.length+1);
//        after[after.length-1] = newElement;
//        return after;
//    }
//

    // używam ArrayListy, ponieważ chcę mieć łatwy dostep do elementów na danym indeksie:
    // w ArrayLiście jest to O(1)
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> result = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f" -> result.add(MoveDirection.FORWARD);
                case "r" -> result.add(MoveDirection.RIGHT);
                case "b" -> result.add(MoveDirection.BACKWARD);
                case "l" -> result.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException("\"" +arg + "\" is not legal move specification");
            }
        }
        return result;
    }

}
