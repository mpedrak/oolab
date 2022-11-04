package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GrassFieldTest
{
    @Test
    public void mapTest()
    {
        MoveDirection[] directions = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection. FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD}; // parser ma swoj test
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        assertTrue(((GrassField)map).getAmountOfGrass() == 10);

        assertTrue(map.objectAt(new Vector2d(2,2))instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(3,4))instanceof Animal);
        assertFalse(map.objectAt(new Vector2d(1,2)) instanceof Animal);

        engine.run();

        assertTrue(((GrassField)map).getAmountOfGrass() == 10);

        assertTrue(map.objectAt(new Vector2d(2,-1))instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(3,7))instanceof Animal);
        assertFalse(map.objectAt(new Vector2d(1,2))instanceof Animal);


        Animal z1 = (Animal)map.objectAt(new Vector2d(2,-1));
        Animal z2 = (Animal)map.objectAt(new Vector2d(3,7));

        assertTrue(z1.okOrientaion(MapDirection.SOUTH));
        assertTrue(z2.okOrientaion(MapDirection.NORTH));


    }
}
