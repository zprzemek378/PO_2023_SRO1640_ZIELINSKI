package agh.ics.oop;
import agh.ics.oop.model.*;

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

    public static void main(String[] args) throws PositionAlreadyOccupiedException {
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





        //rectangular test
//        String[] moves = new String[]{
//                "f", "f", "b", "l", "b", "r", "f", "o", "r", "f", "b", "b", "f", "b", "b", "f", "b", "b", "f", "b", "b", "f", "f", "r", "l"
//        };
//        List<MoveDirection> directions = OptionsParser.parse(moves);
//        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(0,0));
//        Simulation simulation = new Simulation(positions, directions, new RectangularMap(8,5));
//        simulation.run();

        //grass test
        String[] moves = new String[]{
                "f", "f", "b", "l", "b", "f", "l"
        };
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(2,2));

//        String[] moves = args;

        try {
            List<MoveDirection> directions = OptionsParser.parse(moves);
            GrassField grassField = new GrassField(10);
            Simulation simulation = new Simulation(positions, directions, grassField);
            grassField.addObserver(new ConsoleMapDisplay());
            simulation.run();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }



//        try {
//            simulation.run();
//        }
//        catch (PositionAlreadyOccupiedException e) {
//            System.out.println(e);
//        }





        System.out.println("System zakończył działanie");
    }


}
