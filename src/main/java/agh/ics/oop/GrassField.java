package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap
{
    private Map<Vector2d, Grass> trawnik = new HashMap<>();
    private int n;

    public MapBoundary mapB = new MapBoundary();
    public GrassField(int n)
    {
        this.n = n;
        stworzTrawe();
    }

    public String toString()
    {
        MapVisualizer rysownik = new MapVisualizer(this);
        return rysownik.draw(bottomLeft(), upperRight());
    }

    @Override
    public boolean place(Animal animal)
    {
        if (canMoveTo(animal.getPosition()))
        {
            zwierzeta.put(animal.getPosition(), animal);
            mapB.addElement(animal);
            animal.addObserver(mapB);
            animal.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException("Cant place animal on position: " + animal.getPosition());
    }

    @Override
    public Vector2d bottomLeft()
    {
        return mapB.bottomLeft();
    }

    @Override
    public Vector2d upperRight()
    {
        return mapB.upperRight();
    }
    @Override
    public boolean canMoveTo(Vector2d position)
    {
        if(objectAt(position) == null)
            return true;
        if ((objectAt(position) instanceof Grass))  // do dodatkowego (zawsze kiedy canMoveTo zwroci true to zwierze sie poruszy)
        {
            trawnik.remove(position);
            Grass tt = storzJednaTrawe(position);
            trawnik.put(tt.getPosition(), tt);
            mapB.positionChanged(position, tt.getPosition());
            return true;
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position)
    {
        if(zwierzeta.get(position) != null)
            return zwierzeta.get(position);
        if(trawnik.get(position) != null)
            return trawnik.get(position);
        return null;
    }
    private void stworzTrawe()
    {
        final int sqrt10n = (int)sqrt(10 * n);
        Random generator = new Random();
        int i = 0;
        final Vector2d zero0 = new Vector2d(0, 0);
        while (i < n)
        {
            Vector2d pp = new Vector2d(generator.nextInt() % sqrt10n, generator.nextInt() % sqrt10n);
            if (pp.follows(zero0) && objectAt(pp) == null)
            {
                Grass g = new Grass(pp);
                trawnik.put(pp, g);
                mapB.addElement(g);
                i++;
            }
        }
    }
    private Grass storzJednaTrawe(Vector2d old_p)
    {
        final int sqrt10n = (int)sqrt(10 * n);
        Random generator = new Random();
        final Vector2d zero0 = new Vector2d(0, 0);
        while (true)
        {
            Vector2d pp = new Vector2d(generator.nextInt() % sqrt10n, generator.nextInt() % sqrt10n);
            if (pp.follows(zero0) && objectAt(pp) == null && !pp.equals(old_p))
            {
                return new Grass(pp);
            }
        }
    }

    public int getAmountOfGrass()
    {
        return trawnik.size();
    }
}
