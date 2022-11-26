package agh.ics.oop;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.LinkedList;

public class SimulationEngine implements  Runnable // (ThreadedSimulationEngine)
{
    IWorldMap mapa;
    MoveDirection[] ruchy;

    private ArrayList<Animal> zwierzeta = new ArrayList<Animal>();

    private App app = null;

    private int mD;

    public SimulationEngine(MoveDirection[] ruchy, IWorldMap mapa, Vector2d[] pozycje, App app, int mD)
    {
        this.mapa = mapa;
        this.ruchy = ruchy;
        this.app = app;
        this.mD = mD;
        for (Vector2d x: pozycje)
        {
            Animal z = new Animal(mapa, x);
            if(mapa.place(z))
                zwierzeta.add(z);
        }
    }
    public SimulationEngine(IWorldMap mapa, Vector2d[] pozycje, App app, int mD)
    {
        this.mapa = mapa;
        this.app = app;
        this.mD = mD;
        for (Vector2d x: pozycje)
        {
            Animal z = new Animal(mapa, x);
            if(mapa.place(z))
                zwierzeta.add(z);
        }
    }

    public void setDirections(MoveDirection[] ruchy)
    {
        this.ruchy = ruchy;
    }
    public void setMoveDelay(int md)
    {
        this.mD = md;
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
            try
            {
                Thread.sleep(mD);
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex + " przerwanie symulacji");
            }
            Platform.runLater(new Runnable()
            {
                @Override
                public void run()
                {
                    app.renderuj(mapa);
                }
            });
            i++;
            if (i == zwierzeta.size())
                i = 0;
        }
    }

}
