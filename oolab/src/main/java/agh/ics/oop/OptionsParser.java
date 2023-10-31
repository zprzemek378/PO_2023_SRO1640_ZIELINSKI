package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    private static MoveDirection[] append(MoveDirection[] before, MoveDirection newElement) {
        MoveDirection[] after = new MoveDirection[before.length+1];
        after = Arrays.copyOf(before, before.length+1);
        after[after.length-1] = newElement;
        return after;
    }



    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] result = new MoveDirection[0];
        for (String arg : args) {
            switch (arg) {
                case "f" -> result = append(result, MoveDirection.FORWARD);
                case "r" -> result = append(result, MoveDirection.RIGHT);
                case "b" -> result = append(result, MoveDirection.BACKWARD);
                case "l" -> result = append(result, MoveDirection.LEFT);
            }
        }
        return result;
    }

}
