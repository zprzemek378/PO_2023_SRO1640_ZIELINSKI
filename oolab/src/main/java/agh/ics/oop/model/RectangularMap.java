package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap implements WorldMap<Animal, Vector2d> {

    Map<Vector2d, Animal> animals = new HashMap<>();

    private final int width;
    private final int height;
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getAnimalPosition())) return false;

        animals.put(animal.getAnimalPosition(), animal);
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currentKey = animal.getAnimalPosition();
        animals.remove(currentKey);

        animal.move(direction, this);

        animals.put(animal.getAnimalPosition(), animal);

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return  !isOccupied(position) && !(position.getX() < 0
                || position.getX() > width - 1
                || position.getY() < 0
                || position.getY() > height - 1);
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(width-1, height-1));
    }
}