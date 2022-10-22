package agh.ics.oop;

import java.util.LinkedList;

public class RectangularMap implements IWorldMap
{
    private int width;
    private int height;

    private LinkedList<Animal> zwierzeta = new LinkedList<>();

    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    public String toString()
    {
        MapVisualizer rysownik = new MapVisualizer(this);
        rysownik.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }
    /**
     * Indicate if any object can move to the given position.
     *
     * @param position
     *            The position checked for the movement possibility.
     * @return True if the object can move to that position.
     */
    public boolean canMoveTo(Vector2d position)
    {

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

    }
}