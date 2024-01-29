package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.beans.beancontext.BeanContext;
import java.util.*;

public class GrassField extends AbstractWorldMap {

    Map<Vector2d, Grass> grasses = new HashMap<>();


    private final int grassCount;
    private final int maxWidth;
    private final int maxHeight;

    public GrassField(int grassCount) {
        this.grassCount = grassCount;
        this.maxWidth = (int) Math.sqrt(grassCount*10);
        this.maxHeight = (int) Math.sqrt(grassCount*10);


        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassCount);
        Iterator<Vector2d> positionsIterator = randomPositionGenerator.iterator();

        while(positionsIterator.hasNext()) {
            Vector2d grassPosition = positionsIterator.next();
            grasses.put(grassPosition, new Grass(grassPosition));
        }
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(super.objectAt(position) == null) {
            return grasses.get(position);
        }
        return super.objectAt(position);
    }



    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        List<Vector2d> animalsValue = new ArrayList<>(animals.keySet()); //pobieram wartości położeń animals
        List<Vector2d> grassesValue = new ArrayList<>(grasses.keySet()); //pobieram wartości położeń trawy

        List<Vector2d> values = new ArrayList<>(animalsValue);
        values.addAll(grassesValue);

        Vector2d lowerLeft;
        Vector2d upperRight;

        if(!values.isEmpty()) { //jeśli istnieje jakikolwiek element na mapie
            lowerLeft = values.get(0);
            upperRight = values.get(0);

            for(Vector2d value: values) {
                lowerLeft = value.lowerLeft(lowerLeft);
                upperRight = value.upperRight(upperRight);
            }

        }
        else { //jeśli nie istnieje żaden element, to wyświetlaj taką mapę
            lowerLeft = new Vector2d(0,0);
            upperRight = new Vector2d(1,1);
        }

        return mapVisualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public Collection<WorldElement> getElements() {
        List<WorldElement> elements = (List<WorldElement>) super.getElements();
        elements.addAll(grasses.values());

        return elements;
    }
}

