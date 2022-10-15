package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Vector2dTest
{
    @Test
    public void equalsTest()
    {
        assertTrue(new Vector2d(1, 1).equals(new Vector2d(1, 1) ));
        assertFalse(new Vector2d(7, 1).equals(new Vector2d(1, 1) ));
        Vector2d v = new Vector2d(2, 2);
        assertTrue(v.equals(v));
        Integer i = 7;
        assertFalse(new Vector2d(2, 2).equals(i));
    }
    @Test
    public void toStringTest()
    {
        assertEquals(new Vector2d(1,1).toString(), "(1, 1)");
    }
    @Test
    public void precedesTest()
    {
        assertTrue(new Vector2d(1, 1).precedes(new Vector2d(2, 2)));
    }
    @Test
    public void followsTest()
    {
        assertFalse(new Vector2d(1, 1).follows(new Vector2d(2, 2)));
    }
    @Test
    public void upperRightTest()
    {
        assertEquals(new Vector2d(1, 2).upperRight(new Vector2d(2, 1)),
                new Vector2d(2, 2));
    }
    @Test
    public void loweLeftTest()
    {
        assertEquals(new Vector2d(1, 2).lowerLeft(new Vector2d(2, 1)),
                new Vector2d(1, 1));
    }
    @Test
    public void addTest()
    {
        assertEquals(new Vector2d(1, 1).add(new Vector2d(2, 2)),
                new Vector2d(3, 3));
    }
    @Test
    public void substractTest()
    {
        assertEquals(new Vector2d(1, 1).subtract(new Vector2d(2, 2)),
                new Vector2d(-1, -1));
    }
    @Test
    public void oppositeTest()
    {
        assertEquals(new Vector2d(1, 1).opposite(), new Vector2d(-1, -1));
        assertEquals(new Vector2d(0, 0).opposite(), new Vector2d(0, 0));
    }




}
