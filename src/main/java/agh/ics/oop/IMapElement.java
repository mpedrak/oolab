package agh.ics.oop;

import java.io.FileInputStream;

public interface IMapElement // stowrzylem klase zeby bylo pole position, ktorego tu nie mozna
{
    public Vector2d getPosition();
    public String toString();
    public String getPath();
}
