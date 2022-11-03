package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RectangularMapTest
{
    @Test
    public void mapTest()
    {
        MoveDirection[] directions = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection. FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD}; // parser ma swoj test
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(1,2)));

        engine.run();

        assertTrue(map.isOccupied(new Vector2d(2,0)));
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(1,2)));

        Animal z1 = (Animal)map.objectAt(new Vector2d(2,0));
        Animal z2 = (Animal)map.objectAt(new Vector2d(3,4));

        assertTrue(z1.okOrientaion(MapDirection.SOUTH));
        assertTrue(z2.okOrientaion(MapDirection.NORTH));


    }
}
