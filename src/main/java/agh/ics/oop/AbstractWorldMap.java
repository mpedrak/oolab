package agh.ics.oop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver
{
    protected Map<Vector2d, Animal> zwierzeta = new HashMap<>();
    public String toString()
    {
        MapVisualizer rysownik = new MapVisualizer(this);
        return rysownik.draw(bottomLeft(), upperRight());
    }
    public abstract Vector2d bottomLeft();
    public abstract Vector2d upperRight();
    public boolean place(Animal animal)
    {
        if (canMoveTo(animal.getPosition()))
        {
            zwierzeta.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException("Cant place animal on position: " + animal.getPosition());
    }
    public boolean isOccupied(Vector2d position)
    {
        if (objectAt(position) == null)
            return false;
        return true;
    }

    public Object objectAt(Vector2d position)
    {
        if(zwierzeta.get(position) != null)
            return zwierzeta.get(position);
        return null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        Animal aa = zwierzeta.get(oldPosition);
        zwierzeta.remove(oldPosition);
        zwierzeta.put(newPosition, aa);
    }
}
