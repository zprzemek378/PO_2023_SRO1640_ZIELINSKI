package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;

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

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        System.out.println("System zakończył działanie");
    }


}
