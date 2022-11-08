package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionParserTest
{
    @Test
    public void parseTest()
    {
        MoveDirection[] t1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        OptionsParser cpu = new OptionsParser();
        String[] t2 = {"f", "backward", "l", "right"};
        assertArrayEquals(t1, cpu.parse(t2));
    }
    @Test
    public void parseExTest()
    {
        MoveDirection[] t1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        OptionsParser cpu = new OptionsParser();
        String[] t2 = {"7", "f", "bu", "backward", "l", "i", "right", "7"};
        try
        {
            cpu.parse(t2);
        }
        catch(IllegalArgumentException ex)
        {
            assertTrue(true);
        }
    }
}
