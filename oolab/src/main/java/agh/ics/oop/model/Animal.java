package agh.ics.oop.model;

public class Animal implements WorldElement {


    private Vector2d position;


    private MapDirection animalDirection;

    public Animal(Vector2d animalPosition) {
        this.position = animalPosition;
        animalDirection = MapDirection.NORTH;
    }
    public Animal() {
        this(new Vector2d(2,2));
    }

    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }

    public void move(MoveDirection direction, MoveValidator moveValidator) {
        Vector2d newPosition = position;
        switch(direction) {
            case RIGHT -> animalDirection = animalDirection.next();
            case LEFT -> animalDirection = animalDirection.previous();
            case FORWARD -> newPosition = position.add(animalDirection.toUnitVector());
            case BACKWARD -> newPosition = position.subtract(animalDirection.toUnitVector());
        }

        if(!moveValidator.canMoveTo(newPosition)) {
            return;
        }

        position = newPosition;


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

    @Override
    public Vector2d getPosition() {
        return position;
    }



}
