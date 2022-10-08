package agh.ics.oop;
import static java.lang.System.out;
import agh.ics.oop.Direction;
import java.util.Arrays;


public class World
{
    public static void main(String[] args)
    {
        //out.println("system wystartował");
        Direction tab[] = zmien(args);
        run(tab);
        //out.println("system zakończył działanie");
    }
    /*
    public static void run(String[] args)
    {
        out.println("zwierzak idzie do przodu");
        int czy = 1;
        for (String x: args)
        {
            if (czy == 1)
                czy = 0;
            else
                out.print(", ");
            out.print(x);
        }
        out.println();
    }
    */
    public static void run(Direction[] args)
    {
        out.println("Start");
        /*
        for (String x: args)
        {
            String message = switch (x)
            {
                case "f" -> "Zwierzak idzie do przodu";
                case "b" -> "Zwierzak idzie do tyłu";
                case "r" -> "Zwierzak skręca w prawo";
                case "l" -> "Zwierzak skręca w lewo";
                default -> "7";
            };
            if (!message.equals("7"))
                out.println(message);

        }
        */
        for (Direction x: args)
        {
            String message = switch (x)
                    {
                        case f -> "Zwierzak idzie do przodu";
                        case b -> "Zwierzak idzie do tyłu";
                        case r -> "Zwierzak skręca w prawo";
                        case l -> "Zwierzak skręca w lewo";
                        default -> "7";
                    };
            if (!message.equals("7"))
               out.println(message);
        }

        out.println("Stop");
    }
    public static Direction [] zmien(String[] args)
    {
        int li = 0;
        for (String x: args)
            li++;
        Direction tab[] = new Direction[li];
        li = 0;
        for (String x: args)
        {
            Direction message = switch (x)
            {
                case "f" -> Direction.f;
                case "b" -> Direction.b;
                case "r" -> Direction.r;
                case "l" -> Direction.l;
                default -> Direction.g;
            };
            tab[li] = message;
            li++;

        }
        return tab;

    }
}
