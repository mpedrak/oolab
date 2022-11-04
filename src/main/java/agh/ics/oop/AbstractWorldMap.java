package agh.ics.oop;

import java.util.LinkedList;

public abstract class AbstractWorldMap implements IWorldMap
{
    protected LinkedList<Animal> zwierzeta = new LinkedList<Animal>();
    public String toString()
    {
        MapVisualizer rysownik = new MapVisualizer(this);
        return rysownik.draw(bottomLeft(), upperRight());
    }
    protected abstract Vector2d bottomLeft();
    protected abstract Vector2d upperRight();
    public boolean place(Animal animal)
    {
        if (canMoveTo(animal.getPosition()))
        {
            zwierzeta.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position)
    {
        if (objectAt(position) == null)
            return false;
        return true;
    }

    public Object objectAt(Vector2d position)
    {
        for (Animal x: zwierzeta)
        {
            if (x.isAt(position))
                return x;
        }
        return null;
    }
}
