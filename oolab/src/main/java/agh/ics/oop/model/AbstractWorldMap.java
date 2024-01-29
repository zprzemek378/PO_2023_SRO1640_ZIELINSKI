package agh.ics.oop.model;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();


    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }


    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())) return false;

        animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currentKey = animal.getPosition();
        animals.remove(currentKey);

        animal.move(direction, this);

        animals.put(animal.getPosition(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position) ;
    }


    @Override
    public Collection<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

}
