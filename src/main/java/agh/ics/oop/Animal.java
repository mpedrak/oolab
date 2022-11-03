package agh.ics.oop;

import java.util.Objects;

public class Animal extends AbstractWorldMapElement
{
    private MapDirection orientation = MapDirection.NORTH;
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
            position = new_pos;
    }

    public boolean equals(Object other)
    {
        if (this == other)
            return true;
        if (!(other instanceof Animal))
            return false;
        Animal that = (Animal) other;
        if (this.position.equals(that.position) && this.orientation == that.orientation)
            return true;
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(orientation, position);
    }
}
