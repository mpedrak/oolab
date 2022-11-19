package agh.ics.oop;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Objects;

public class Animal extends AbstractWorldMapElement
{
    private MapDirection orientation = MapDirection.NORTH;
    private LinkedList<IPositionChangeObserver> obserwatorzy = new LinkedList<>();
    private IWorldMap map;


    public String toString()
    {
        return orientation.toShortString();
    }



    public Animal()
    {
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map)
    {
        this.map = map;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this.map = map;
        this.position = initialPosition;
    }

    public boolean isAt(Vector2d position)
    {
        if (this.position.equals(position))
            return true;
        return false;
    }
    public boolean okOrientaion(MapDirection o) // do sprawdzenia w testach orientacji, ktora jest prywatna
    {
        if (this.orientation.equals(o))
            return true;
        return false;
    }
    public void move(MoveDirection direction)
    {
        if (direction.equals(MoveDirection.RIGHT))
            orientation = orientation.next();
        if (direction.equals(MoveDirection.LEFT))
            orientation = orientation.prev();
        Vector2d new_pos = new Vector2d(position.x, position.y);
        if (direction.equals(MoveDirection.FORWARD))
            new_pos = new_pos.add(orientation.toUnitVector());
        if (direction.equals(MoveDirection.BACKWARD))
            new_pos = new_pos.subtract(orientation.toUnitVector());
        if (map.canMoveTo(new_pos))
        {
            positionChanged(position, new_pos);
        }
    }

    public boolean equals(Object other)
    {


        if (!(other instanceof Animal))
            return false;
        Animal that = (Animal) other;
        if (this == that)
            return true;
        if (this.position.equals(that.position) && this.orientation == that.orientation)
            return true;
        return false;


    }

    @Override
    public int hashCode()
    {
        return Objects.hash(orientation, position);
    }
    public void addObserver(IPositionChangeObserver observer)
    {
        if (!obserwatorzy.contains(observer))
            obserwatorzy.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer)
    {
        obserwatorzy.remove(observer);
    }
    private void positionChanged(Vector2d old_p, Vector2d new_p)
    {
        for (IPositionChangeObserver x: obserwatorzy)
            x.positionChanged(old_p, new_p);
    }
    public String getPath()
    {
        switch(this.orientation)
        {
            case NORTH: return "src/main/resources/up.png";
            case SOUTH: return "src/main/resources/down.png";
            case WEST: return "src/main/resources/left.png";
            case EAST: return "src/main/resources/right.png";
        }
        return "7";
    }
}
