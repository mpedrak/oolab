package agh.ics.oop;

import java.util.LinkedList;

public class RectangularMap extends AbstractWorldMap
{

    public RectangularMap(int width, int height)
    {
        this.width = width;
        this.height = height;
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
