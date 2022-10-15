package agh.ics.oop;

public class Animal
{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString()
    {
        return "Pozycja: " + position.toString() + ", orientacja: " + orientation.toString();
    }

    public boolean isAt(Vector2d position)
    {
        if (this.position.equals(position))
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
        if (new_pos.precedes(new Vector2d(4,4)) && new_pos.follows(new Vector2d(0, 0)))
            position = new_pos;


    }

}
