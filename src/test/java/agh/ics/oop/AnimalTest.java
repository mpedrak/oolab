package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AnimalTest // nieaktualne testy bo zmieniona metoda move
{
    @Test
    public void animalTest()
    {
        Animal zwierz = new Animal();
        assertTrue(zwierz.isAt(new Vector2d(2, 2)));
        assertTrue(zwierz.okOrientaion(MapDirection.NORTH));
        zwierz.move(MoveDirection.RIGHT);
        assertTrue(zwierz.okOrientaion(MapDirection.EAST));
        zwierz.move(MoveDirection.FORWARD);
        assertTrue(zwierz.isAt(new Vector2d(3, 2)));
        zwierz.move(MoveDirection.FORWARD);
        assertTrue(zwierz.isAt(new Vector2d(4, 2)));
        zwierz.move(MoveDirection.FORWARD);
        assertTrue(zwierz.isAt(new Vector2d(4, 2))); // czy nie wyjdzie poza mape
        zwierz.move(MoveDirection.LEFT);
        assertTrue(zwierz.okOrientaion(MapDirection.NORTH));
        zwierz.move(MoveDirection.LEFT);
        assertTrue(zwierz.okOrientaion(MapDirection.WEST));
    }

}
