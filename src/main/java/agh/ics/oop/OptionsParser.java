package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OptionsParser
{
    public MoveDirection[] parse(String[] tab)
    {
        MoveDirection[] wynik = new MoveDirection[tab.length];
        int i = 0;
        for(String x: tab)
        {
            switch (x)
            {
                case "f", "forward": wynik[i] = MoveDirection.FORWARD; break;
                case "b", "backward": wynik[i] = MoveDirection.BACKWARD; break;
                case "r", "right": wynik[i] = MoveDirection.RIGHT; break;
                case "l", "left": wynik[i] = MoveDirection.LEFT; break;
                default: i--;
            }
            i++;
        }
        return Arrays.copyOfRange(wynik, 0, i);
    }
}
