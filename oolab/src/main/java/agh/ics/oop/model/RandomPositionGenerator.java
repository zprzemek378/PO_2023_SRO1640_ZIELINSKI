package agh.ics.oop.model;

import java.util.*;

public class RandomPositionGenerator implements Iterable {

    private final int maxWidth;
    private final int maxHeight;
    private final int grassCount;
    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassCount = grassCount;
    }


    private List<Vector2d> generateRandomPositions() {
        List<Vector2d> positions = new ArrayList<>();

        for(int i=0; i<maxWidth; i++) {
            for(int j=0; j< maxHeight; j++) {
                positions.add(new Vector2d(i,j));
            }
        }

        Collections.shuffle(positions, new Random());

        return positions.subList(0,grassCount);

    }


    @Override
    public Iterator<Vector2d> iterator() {
        return new Iterator<Vector2d>() {        //implements iterator

            private int current = -1;
            private final List<Vector2d> positions = generateRandomPositions();
            @Override
            public boolean hasNext() {
                return current + 1 < grassCount;
            }

            @Override
            public Vector2d next() {
                current++;
                return positions.get(current);

            }
        };
    }

}
