package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {


    private final int width;
    private final int height;
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return  super.canMoveTo(position) && !(position.getX() < 0
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
