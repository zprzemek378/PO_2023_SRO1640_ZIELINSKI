package agh.ics.oop.model;

import java.net.NoRouteToHostException;

public enum MapDirection {
    NORTH("Północ"),
    SOUTH("Południe"),
    WEST("Zachód"),
    EAST("Wschód");

    public final String direction;

    MapDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }

    public MapDirection next() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public MapDirection previous() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }

    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
        };
    }


}
