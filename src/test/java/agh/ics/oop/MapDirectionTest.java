package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest
{
    @Test
    public void nextTest()
    {
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
    }
    @Test
    public void prevTest()
    {
        assertEquals(MapDirection.NORTH.prev(), MapDirection.WEST);
        assertEquals(MapDirection.EAST.prev(), MapDirection.NORTH);
        assertEquals(MapDirection.SOUTH.prev(), MapDirection.EAST);
        assertEquals(MapDirection.WEST.prev(), MapDirection.SOUTH);
    }


}
