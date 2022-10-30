package agh.ics.oop;

public class Grass
{
    private Vector2d position;

    public Grass(Vector2d p)
    {
        this.position = p;
    }
    public Vector2d getPosition()
    {
        return this.position;
    }
    public String toString()
    {
        return "*";
    }
}
