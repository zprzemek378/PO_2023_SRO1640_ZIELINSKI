package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int counter = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        counter++;
        System.out.println("Update " + counter + ": " + message);
        System.out.println(worldMap.toString());
    }
}
