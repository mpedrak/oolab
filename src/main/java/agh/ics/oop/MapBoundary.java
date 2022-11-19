package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver
{

    public TreeSet< AbstractWorldMapElement> zbiorX = new TreeSet<>(new Comparator<AbstractWorldMapElement>()
    {
        public int compare (AbstractWorldMapElement a, AbstractWorldMapElement b)
        {
            Vector2d va = a.getPosition();
            Vector2d vb = b.getPosition();
            if (va.x == vb.x)               // nie trzeba porównywać typów bo nie może być 2 na jednej pozycji
                return va.y - vb.y;
            return va.x - vb.x;
        }
    }
    );
    public TreeSet< AbstractWorldMapElement> zbiorY = new TreeSet<>(new Comparator<AbstractWorldMapElement>()
    {
        public int compare (AbstractWorldMapElement a, AbstractWorldMapElement b)
        {
            Vector2d va = a.getPosition();
            Vector2d vb = b.getPosition();
            if (va.y == vb.y)               // nie trzeba porównywać typów bo nie może być 2 na jednej pozycji
                return va.x - vb.x;
            return va.y - vb.y;
        }
    }
    );
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {

        AbstractWorldMapElement z = null;
        for (AbstractWorldMapElement x : zbiorX)
            if (x.getPosition().equals(oldPosition))
                z = x;

        if (z instanceof Animal)
        {
            zbiorX.remove(z);
            zbiorY.remove(z);
            z.position = newPosition;
            zbiorX.add(z);
            zbiorY.add(z);

        }
        else
        {
            Grass g = new Grass(newPosition);
            zbiorX.remove(z);
            zbiorX.add(g);
            zbiorY.remove(z);
            zbiorY.add(g);
        }

    }
    public void addElement(AbstractWorldMapElement z)
    {
        zbiorX.add(z);
        zbiorY.add(z);
    }
    public Vector2d bottomLeft()
    {
        return new Vector2d(zbiorX.first().getPosition().x, zbiorY.first().getPosition().y);
    }
    public Vector2d upperRight()
    {
        return new Vector2d(zbiorX.last().getPosition().x, zbiorY.last().getPosition().y);
    }


}


