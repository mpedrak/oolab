package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimulationEngine implements IEngine, Runnable
{
    IWorldMap mapa;
    MoveDirection[] ruchy;

    private ArrayList<Animal> zwierzeta = new ArrayList<Animal>();

    public SimulationEngine(MoveDirection[] ruchy, IWorldMap mapa, Vector2d[] pozycje)
    {
        this.mapa = mapa;
        this.ruchy = ruchy;
        for (Vector2d x: pozycje)
        {
            Animal z = new Animal(mapa, x);
            z.addObserver((IPositionChangeObserver) mapa);
            if(mapa instanceof GrassField)
                z.addObserver((IPositionChangeObserver) (((GrassField) mapa).mapB));
            if(mapa.place(z))
                zwierzeta.add(z);
        }
    }

    /**
     * Move the animal on the map according to the provided move directions. Every
     * n-th direction should be sent to the n-th animal on the map.
     *
     */
    public void run()
    {
        int i = 0;
        for (MoveDirection x: ruchy)
        {
            Animal zwierz = zwierzeta.get(i);
            zwierz.move(x);

            /*
            System.out.println(i + ", " + x);
            System.out.println(mapa);
            System.out.println("Ilosc trawy: " + ((GrassField)mapa).getAmountOfGrass());
            */

            i++;
            if (i == zwierzeta.size())
                i = 0;
        }
    }
}
