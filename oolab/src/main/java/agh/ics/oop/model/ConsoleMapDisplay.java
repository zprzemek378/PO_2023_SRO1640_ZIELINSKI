package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int counter = 0;
    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message) {
        counter++;
        System.out.println("[UUID: " + worldMap.getId() + "] Update " + counter + ": " + message);
        System.out.println(worldMap);
    }
}
