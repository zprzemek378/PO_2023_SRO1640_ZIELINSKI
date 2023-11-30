package agh.ics.oop.model;

import java.util.Objects;

public class StringText {


    private MapDirection direction;
    private final String text;

    public StringText(String text, MapDirection direction) {
        this.text = text;
        this.direction = direction;
    }

    public StringText(String text) {
        this(text, MapDirection.NORTH);
    }

    public MapDirection getDirection() {
        return direction;
    }

    public String getText() {
        return text;
    }

    public void setPrev() {
        direction = direction.previous();
    }
    public void setNext() {
        direction = direction.next();
    }

    @Override
    public String toString() {
        return "StringText{" +
                "direction=" + direction +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringText that = (StringText) o;
        return direction == that.direction && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, text);
    }
}
