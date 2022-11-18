package agh.ics.oop;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;


public class App extends Application
{

    public void start(Stage primaryStage)
    {

        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        GridPane grid = new GridPane();

        grid.setGridLinesVisible(true);

        Vector2d bottomLeft = ((GrassField)map).bottomLeft();
        Vector2d upperRight = ((GrassField)map).upperRight();

        Label xy = new Label("y\\x");
        grid.add(xy, 0, 0, 1, 1);
        GridPane.setHalignment(xy, HPos.CENTER);

        int width = 20;
        int height = 20;

        for (int i = 0; i <= upperRight.x - bottomLeft.x + 1; i++)
            grid.getColumnConstraints().add(new ColumnConstraints(width));
        for (int i = 0; i <= upperRight.y - bottomLeft.y + 1; i++)
            grid.getRowConstraints().add(new RowConstraints(height));

        for (int i = bottomLeft.x ; i <= upperRight.x; ++i)
        {
            Label s = new Label(Integer.toString(i));
            grid.add(s, i - bottomLeft.x + 1, 0, 1, 1);
            GridPane.setHalignment(s, HPos.CENTER);
        }

        int j = 1;
        for (int i = upperRight.y; i >= bottomLeft.y; --i)
        {
            Label s = new Label(Integer.toString(i));
            grid.add(s, 0, j, 1, 1);
            GridPane.setHalignment(s, HPos.CENTER);
            ++j;
        }


        for (int x = bottomLeft.x ; x <= upperRight.x ; ++x)
        {
            j = 1;
            for (int y = upperRight.y; y >= bottomLeft.y; --y)
            {
                Object z = ((GrassField) map).objectAt(new Vector2d(x, y));
                if (z != null)
                {
                    Label l = new Label(z.toString());
                    grid.add(l, x - bottomLeft.x + 1, j, 1, 1);
                    GridPane.setHalignment(l, HPos.CENTER);
                }
                ++j;
            }
        }

        Scene scene = new Scene(grid, width * (upperRight.x - bottomLeft.x + 2), height * (upperRight.y - bottomLeft.y + 2));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
