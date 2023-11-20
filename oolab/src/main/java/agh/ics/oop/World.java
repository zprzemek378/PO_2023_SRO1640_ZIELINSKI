package agh.ics.oop;
import agh.ics.oop.model.*;
import org.w3c.dom.Text;

import java.util.List;

public class World {
//    public static void run(MoveDirection[] moves) {
//        for (MoveDirection move : moves) {
//            switch (move) {
//                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
//                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
//                case BACKWARD -> System.out.println("Zwierzak iddzie do tyłu");
//                case LEFT -> System.out.println("Zwierzak skręca w lewo");
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println("System wystartował");
//        run(OptionsParser.parse(args));

//        MapDirection varr = MapDirection.SOUTH;
//        MapDirection varr2 = varr.next().previous().previous();
//        System.out.println(varr2.toUnitVector());

//        Vector2d position = new Vector2d(3,4);
//        Animal animal = new Animal(position);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.LEFT);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.BACKWARD);
//        System.out.println(animal);
//        System.out.println(animal.isAt(new Vector2d(3,7)));

//        List<MoveDirection> directions = OptionsParser.parse(args);
//        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        Simulation simulation = new Simulation(positions, directions);
//        simulation.run();

//        RectangularMap rectangularMap = new RectangularMap(3,4);
//
//        System.out.println(        rectangularMap.getAnimals());

//        String[] moves = new String[]{
//                "f", "f", "b", "l", "b", "r", "f", "o", "r", "f", "b", "b", "f", "b", "b", "f", "b", "b", "f", "b", "b", "f", "f", "r", "l"
//
//        };
//        List<MoveDirection> directions = OptionsParser.parse(moves);
//        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(0,0));
//        Simulation simulation = new Simulation(positions, directions, new RectangularMap(8,5));
//        simulation.run();

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






        System.out.println("System zakończył działanie");
    }


}
