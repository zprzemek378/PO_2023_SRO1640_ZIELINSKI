package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public List<Animal> getAnimals() {
        return animals;
    }

    private List<Animal> animals = new ArrayList<>();
    private List<MoveDirection> moves = new ArrayList<>();

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves) {
        for (Vector2d position : positions) {
            animals.add(new Animal(position));
        }
        this.moves = moves;
    }

    public void run() {
        int i = 0;
        for(MoveDirection move : moves) {
            animals.get(i).move(move);
            i = (i+1)%animals.size();
            System.out.println("Zwierzę " + i + ": " + animals.get(i));
        }
    }
}
