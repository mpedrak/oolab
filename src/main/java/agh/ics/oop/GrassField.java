package agh.ics.oop;

import java.util.LinkedList;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

public class GrassField implements IWorldMap
{
    private LinkedList<Animal> zwierzeta = new LinkedList<Animal>();

    private LinkedList<Grass> zdzbla_trawy = new LinkedList<Grass>();

    private int wymiar_dla_trawy;

    public GrassField(int n)
    {
        this.wymiar_dla_trawy = (int)sqrt(n * 10);
        umiesc_trawe(n);
    }

    public String toString()
    {
        MapVisualizer rysownik = new MapVisualizer(this);
        Vector2d upperRight = new Vector2d(0, 0);
        for (Animal x: zwierzeta)
        {
            upperRight = upperRight.upperRight(x.getPosition());
        }
        for (Grass x: zdzbla_trawy)
        {
            upperRight = upperRight.upperRight(x.getPosition());
        }
        return rysownik.draw(new Vector2d(0, 0), upperRight);
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
        if (position.follows(new Vector2d(0, 0)) && !isOccupied(position))
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
        for (Grass x: zdzbla_trawy)
        {
            if (x.getPosition().equals(position))
                return x;
        }
        return null;
    }

    private void umiesc_trawe(int n)
    {
        int i = 0;
        Random generator = new Random();
        while (i < n)
        {
            Vector2d potencialna_pozycja = new Vector2d(generator.nextInt() % wymiar_dla_trawy,
                    generator.nextInt() % wymiar_dla_trawy);
            if (placeGrass(new Grass(potencialna_pozycja)))
                i++;
        }
    }
    private boolean placeGrass(Grass trawa)
    {
        if (!hasGrass(trawa.getPosition()))
        {
            zdzbla_trawy.add(trawa);
            return true;
        }
        return false;
    }
    private boolean hasGrass(Vector2d pos)
    {
        if (objectAtForGrass(pos) == null)
            return false;
        return true;
    }
    private Object objectAtForGrass(Vector2d pos)
    {
        for (Grass x: zdzbla_trawy)
        {
            if (x.getPosition().equals(pos))
                return x;
        }
        return null;
    }
}
