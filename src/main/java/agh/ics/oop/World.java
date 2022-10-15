package agh.ics.oop;

import java.util.Arrays;
import java.util.Map;

public class World
{
    public static void main(String[] args)
    {
        OptionsParser cpu = new OptionsParser();
        MoveDirection[] polecenia = cpu.parse(args);
        //System.out.println(Arrays.toString(args));
        //System.out.println(Arrays.toString(polecenia));
        Animal zwierz = new Animal();
        System.out.println(zwierz);
        for (MoveDirection x: polecenia)
            zwierz.move(x);
        System.out.println(zwierz);

        /*
        Animal zwierz = new Animal();
        System.out.println(zwierz);
        zwierz.move(MoveDirection.RIGHT);
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.FORWARD);
        System.out.println(zwierz);
        String[] tab = new String[3];
        tab[0] = "r";
        tab[1] = "b";
        tab[2] = "c";
        OptionsParser nwm = new OptionsParser();
        System.out.println(Arrays.toString(nwm.parse(tab)));
        */

    }

}
