package agh.ics.oop.model;

public class Animal {


    private Vector2d animalPosition;


    private MapDirection animalDirection;

    public Animal(Vector2d animalPosition) {
        this.animalPosition = animalPosition;
        animalDirection = MapDirection.NORTH;
    }
    public Animal() {
        this(new Vector2d(2,2));
    }

    public boolean isAt(Vector2d position) {
        return position.equals(animalPosition);
    }

    public void move(MoveDirection direction, MoveValidator moveValidator) {
        Vector2d newPosition = animalPosition;
        switch(direction) {
            case RIGHT -> animalDirection = animalDirection.next();
            case LEFT -> animalDirection = animalDirection.previous();
            case FORWARD -> newPosition = animalPosition.add(animalDirection.toUnitVector());
            case BACKWARD -> newPosition = animalPosition.subtract(animalDirection.toUnitVector());
        }

        if(!moveValidator.canMoveTo(newPosition)) {
            return;
        }

        animalPosition = newPosition;


    }

    @Override
    public String toString() {
        return switch(animalDirection) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
    }

    public MapDirection getAnimalDirection() {
        return animalDirection;
    }

    public Vector2d getAnimalPosition() {
        return animalPosition;
    }



}
