package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public List<Animal> getAnimals() {
        return animals;
    }

    private List<Animal> animals = new ArrayList<>();
    private List<MoveDirection> moves = new ArrayList<>();
    private WorldMap worldMap;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap worldMap) {
        for (Vector2d position : positions) {
            animals.add(new Animal(position));
        }
        this.moves = moves;
        this.worldMap = worldMap;
    }

    public void run() {
//        add animals to RectangularMap
        for (Animal animal : animals) {
            worldMap.place(animal);
        }


        int i = 0;
        for(MoveDirection move : moves) {
            Animal currentAnimal = animals.get(i);
            worldMap.move(currentAnimal, move);

            i = (i+1)%animals.size();
//            System.out.println("Zwierzę " + i + ": " + animals.get(i));
//            System.out.println(move);
            System.out.println(worldMap);

        }
    }
}
