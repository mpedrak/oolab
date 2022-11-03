package agh.ics.oop;

public abstract class AbstractWorldMapElement implements IMapElement // mozna dodac pole position oraz implemetecje getPosition
{
    protected Vector2d position;
    @Override
    public Vector2d getPosition()
    {
        return position;
    }
}
