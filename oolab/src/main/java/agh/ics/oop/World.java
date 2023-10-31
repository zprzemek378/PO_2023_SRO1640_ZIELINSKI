package agh.ics.oop;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class World {
    public static void run(MoveDirection[] moves) {
        for (MoveDirection move : moves) {
            switch (move) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case BACKWARD -> System.out.println("Zwierzak iddzie do tyłu");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("System wystartował");
//        run(OptionsParser.parse(args));

        MapDirection varr = MapDirection.SOUTH;
        MapDirection varr2 = varr.next().previous().previous();
        System.out.println(varr2.toUnitVector());



        System.out.println("System zakończył działanie");
    }


}
