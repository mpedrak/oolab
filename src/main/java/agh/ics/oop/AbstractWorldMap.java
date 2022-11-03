package agh.ics.oop;

import java.util.LinkedList;

public abstract class AbstractWorldMap implements IWorldMap
{
    protected int width;
    protected int height;
    protected LinkedList<Animal> zwierzeta = new LinkedList<Animal>();

    public String toString()
    {
        MapVisualizer rysownik = new MapVisualizer(this);
        return rysownik.draw(bottomLeft(), upperRight());
    }
    protected abstract Vector2d bottomLeft();
    protected abstract Vector2d upperRight();
    /**
     * Indicate if any object can move to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    public boolean canMoveTo(Vector2d position)
    {
        if (position.follows(new Vector2d(0, 0)) &&
                position.precedes(new Vector2d(width - 1, height - 1))
                && !isOccupied(position))
            return true;
        return false;
    }

    /**
     * Place a animal on the map.
     *
     * @param animal
     *            The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the map is already occupied.
     */
    public boolean place(Animal animal)
    {
        if (canMoveTo(animal.getPosition()))
        {
            zwierzeta.add(animal);
            return true;
        }
        return false;
    }

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position
     *            Position to check.
     * @return True if the position is occupied.
     */
    public boolean isOccupied(Vector2d position)
    {
        if (objectAt(position) == null)
            return false;
        return true;
    }

    /**
     * Return an object at a given position.
     *
     * @param position
     *            The position of the object.
     * @return Object or null if the position is not occupied.
     */
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
