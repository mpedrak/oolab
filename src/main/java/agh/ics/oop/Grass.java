package agh.ics.oop;

import java.util.Objects;

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
    public boolean equals(Object other)
    {


        if (!(other instanceof Grass))
            return false;
        Grass that = (Grass) other;
        if (this == that)
            return true;
        if (this.position.equals(that.position))
            return true;
        return false;


    }

    @Override
    public int hashCode()
    {
        return Objects.hash(position);
    }

    public String getPath()
    {
        return "src/main/resources/grass.png";
    }
}
