package agh.ics.oop;

public class Grass extends AbstractWorldMapElement
{
    public Grass(Vector2d p)
    {
        this.position = p;
    }
    public String toString()
    {
        return "*";
    }
}
