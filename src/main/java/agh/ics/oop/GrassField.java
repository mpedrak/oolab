package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap
{
    private Map<Vector2d, Grass> trawnik = new HashMap<>();
    private int n;
    public GrassField(int n)
    {
        this.n = n;
        stworzTrawe();
    }

    @Override
    protected Vector2d bottomLeft()
    {
        final int sqrt10n = (int)sqrt(10 * n);
        Vector2d bottomLeft = new Vector2d(sqrt10n, sqrt10n);
        for (Animal x: zwierzeta.values())
        {
            bottomLeft = bottomLeft.lowerLeft(x.getPosition());
        }
        for (Grass x: trawnik.values())
        {
            bottomLeft = bottomLeft.lowerLeft(x.getPosition());
        }
       return bottomLeft;
    }

    @Override
    protected Vector2d upperRight()
    {
        Vector2d upperRight = new Vector2d(0, 0);
        for (Animal x: zwierzeta.values())
        {
            upperRight = upperRight.upperRight(x.getPosition());
        }
        for (Grass x: trawnik.values())
        {
            upperRight = upperRight.upperRight(x.getPosition());
        }
        return upperRight;
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
                trawnik.put(pp, new Grass(pp));
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
