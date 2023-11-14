package agh.ics.oop.model;

public class Animal {
    public Vector2d getAnimalPosition() {
        return animalPosition;
    }

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

    public void move(MoveDirection direction) {
        Vector2d newPosition = animalPosition;
        switch(direction) {
            case RIGHT -> animalDirection = animalDirection.next();
            case LEFT -> animalDirection = animalDirection.previous();
            case FORWARD -> newPosition = animalPosition.add(animalDirection.toUnitVector());
            case BACKWARD -> newPosition = animalPosition.subtract(animalDirection.toUnitVector());
        }
        newPosition = newPosition.upperRight(new Vector2d(0,0));
        newPosition = newPosition.lowerLeft(new Vector2d(4,4));
        animalPosition = newPosition;
    }

    @Override
    public String toString() {
        return animalPosition + ", " + animalDirection;
    }

    public MapDirection getAnimalDirection() {
        return animalDirection;
    }



}
