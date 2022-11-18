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
    public Vector2d bottomLeft()
    {
        return new Vector2d(0 ,0);
    }

    @Override
    public Vector2d upperRight()
    {
        return new Vector2d(width - 1, height - 1);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        Animal aa = zwierzeta.get(oldPosition);
        aa.position = newPosition;
        zwierzeta.remove(oldPosition);
        zwierzeta.put(newPosition, aa);
    }
}
