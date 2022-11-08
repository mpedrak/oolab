package agh.ics.oop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


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

        Vector2d boottomLeft = ((AbstractWorldMap)map).bottomLeft();
        Vector2d uppwerRight = ((AbstractWorldMap)map).upperRight();

        Label label1 = new Label("Zwierzak");
        Label label2 = new Label("Zwierzak");
        grid.add(label1, 0, 0, 1, 1);
        grid.add(label2, 1, 0, 1, 1);

        Scene scene = new Scene(grid, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
