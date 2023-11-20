package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextMap implements WorldMap<String, Integer> {

    public List<StringText> getTexts() {
        return texts;
    }

    private final List<StringText> texts = new ArrayList<>();

    @Override
    public boolean canMoveTo(Integer position) {
        return !(isOccupied(position)) && position <= texts.size() - 1 && position >= 0;
    }

    @Override
    public boolean place(String text) {
        texts.add(new StringText(text));
        return true;
    }

    private StringText getElementByText(String text) {
        for(StringText stringText: texts) {
            if(stringText.getText().equals(text)) {
                return stringText;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for(StringText stringText : texts) {
            result = result + stringText.getText() + " ";
        }
        return result;
    }

    @Override
    public void move(String text, MoveDirection direction) {
        StringText stringText = getElementByText(text);
        if(stringText == null) return;
        MapDirection stringDirection = stringText.getDirection();
        int oldPosition = texts.indexOf(stringText);
        int newPosition = oldPosition;
        switch(direction) {
            case FORWARD -> {
                if(stringDirection == MapDirection.NORTH || stringDirection == MapDirection.SOUTH) return;
                else if(stringDirection == MapDirection.EAST) newPosition++;
                else if(stringDirection == MapDirection.WEST) newPosition--;
            }
            case BACKWARD -> {
                if(stringDirection == MapDirection.NORTH || stringDirection == MapDirection.SOUTH) return;
                else if(stringDirection == MapDirection.EAST) newPosition--;
                else if(stringDirection == MapDirection.WEST) newPosition++;
            }
            case LEFT -> {
                stringText.setPrev();
                return;
            }
            case RIGHT -> {
                stringText.setNext();
                return;
            }
        }
        if(!canMoveTo(newPosition)) return;

        StringText temp = texts.get(newPosition);
        texts.set(newPosition, texts.get(oldPosition));
        texts.set(oldPosition, temp);

        System.out.println(this.toString());
    }

    @Override
    public boolean isOccupied(Integer position) {
        return false;
    }

    @Override
    public String objectAt(Integer position) {
        return null;
    }


}
