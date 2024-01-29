package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    private final UUID id = UUID.randomUUID();

    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }

    private List<MapChangeListener> observers = new ArrayList<>();

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    public void mapChanged(String message) {
//        for (MapChangeListener observer : observers) {
//            observer.mapChanged(this, message);
//        }
    }


    @Override
    public boolean place(Animal animal) throws PositionAlreadyOccupiedException {
        if(!canMoveTo(animal.getPosition())) {
//            return false;
            //brak wiadomości - nic sie nie zmieniło
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }

        animals.put(animal.getPosition(), animal);
        mapChanged("Added animal at position (" + animal.getPosition().getX() + ", " + animal.getPosition().getY() + ")");
        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currentKey = animal.getPosition();
        MapDirection oldDirection = animal.getAnimalDirection();
        animals.remove(currentKey);

        animal.move(direction, this);

        animals.put(animal.getPosition(), animal);
        mapChanged("Moved animal from [(" + currentKey.getX() + ", " + currentKey.getY() + "), " + oldDirection + "] to [(" + animal.getPosition().getX() + ", " + animal.getPosition().getY()+ "), " + animal.getAnimalDirection() + "]");
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

    @Override
    public abstract Boundary getCurrentBounds();

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);

        return mapVisualizer.draw(getCurrentBounds().bottomLeft(), getCurrentBounds().upperRight());
    }

    @Override
    public UUID getId() {
        return id;
    }


}
