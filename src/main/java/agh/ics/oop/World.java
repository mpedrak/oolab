package agh.ics.oop;

import java.util.Arrays;
import java.util.Map;

public class World
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(args));
        MoveDirection[] directions = new OptionsParser().parse(args);
        System.out.println(Arrays.toString(directions));
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        System.out.println("0 - start w (2,2), 1 - start w (3,4)");
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        engine.run();
        System.out.println(map);
    }

}
