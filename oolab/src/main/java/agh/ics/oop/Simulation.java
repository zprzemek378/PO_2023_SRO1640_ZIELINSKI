package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Simulation {



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
        Iterator<Animal> iterator = animals.iterator();
        while(iterator.hasNext()) {
            Animal animal = iterator.next();
            try {
                worldMap.place(animal);
            } catch (PositionAlreadyOccupiedException e) {
                iterator.remove();
                e.printStackTrace();
            }
        }


        int i = 0;
        for(MoveDirection move : moves) {
            Animal currentAnimal = animals.get(i);
            worldMap.move(currentAnimal, move);

            i = (i+1)%animals.size();
//            System.out.println("Zwierzę " + i + ": " + animals.get(i));
//            System.out.println(move);
//            System.out.println(worldMap);

        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
    public WorldMap getWorldMap() {
        return worldMap;
    }
}
