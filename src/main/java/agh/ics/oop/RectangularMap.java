package agh.ics.oop;

import java.util.LinkedList;

public class RectangularMap extends AbstractWorldMap
{
    private int width;
    private int height;

    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    public boolean canMoveTo(Vector2d position)
    {
        if (position.follows(new Vector2d(0, 0)) &&
                position.precedes(new Vector2d(width - 1, height - 1))
                && !isOccupied(position))
            return true;
        return false;
    }

    @Override
    protected Vector2d bottomLeft()
    {
        return new Vector2d(0 ,0);
    }

    @Override
    protected Vector2d upperRight()
    {
        return new Vector2d(width - 1, height - 1);
    }
}
