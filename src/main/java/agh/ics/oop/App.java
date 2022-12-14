package agh.ics.oop;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;



public class App  extends Application
{

    public GridPane grid = null;

    public void start(Stage primaryStage)
    {

        //f b r l f f r r f f f f f f f f r


        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        int moveDelay = 300;
        Runnable engine = new SimulationEngine(directions, map, positions, this, moveDelay);

        grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.getStyleClass().add("grid");
        grid.setHgap(1);
        grid.setVgap(1);
        Scene scene = new Scene(grid, 1000, 1000);
        scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

        renderujStart(map, engine);
    }

    public void renderuj(IWorldMap map)
    {

        Vector2d bottomLeft = ((GrassField)map).bottomLeft();
        Vector2d upperRight = ((GrassField)map).upperRight();

        grid.getChildren().clear();
        grid.setGridLinesVisible(true);

        VBox vbox = new VBox();
        Label s = new Label( "\n" + "   " + "y\\x");
        vbox.getChildren().addAll(s);
        vbox.getStyleClass().add("cell");
        grid.add(vbox, 0, 0, 1, 1);
        GridPane.setHalignment(vbox, HPos.CENTER);

        int width = 40;
        int height = 40;

        for (int i = 0; i <= upperRight.x - bottomLeft.x + 1; i++)
            grid.getColumnConstraints().add(new ColumnConstraints(width));
        for (int i = 0; i <= upperRight.y - bottomLeft.y + 1; i++)
            grid.getRowConstraints().add(new RowConstraints(height));

        for (int i = bottomLeft.x ; i <= upperRight.x; ++i)
        {
            vbox = new VBox();
            s = new Label("\n" + "     " + Integer.toString(i));
            vbox.getChildren().addAll(s);
            vbox.getStyleClass().add("cell");
            grid.add(vbox, i - bottomLeft.x + 1, 0, 1, 1);
        }

        int j = 1;
        for (int i = upperRight.y; i >= bottomLeft.y; --i)
        {
            vbox = new VBox();
            s = new Label("\n" + "     " + Integer.toString(i));
            vbox.getChildren().addAll(s);
            vbox.getStyleClass().add("cell");
            grid.add(vbox, 0, j, 1, 1);
            ++j;
        }


        for (int x = bottomLeft.x ; x <= upperRight.x ; ++x)
        {
            j = 1;
            for (int y = upperRight.y; y >= bottomLeft.y; --y)
            {
                Object z = ((GrassField) map).objectAt(new Vector2d(x, y));
                GuiElementBox element = null;
                try
                {
                    element = new GuiElementBox((IMapElement)z);
                }
                catch (FileNotFoundException ex)
                {
                    System.out.println(ex);
                }
                element.vbox.getStyleClass().add("cell");
                grid.add(element.vbox, x - bottomLeft.x + 1, j, 1, 1);
                GridPane.setHalignment(element.vbox, HPos.CENTER);


                ++j;
            }
        }

    }
    private void renderujStart(IWorldMap map, Runnable engine)
    {

        grid.getChildren().clear();
        int width = 40;
        int height = 40;
        for (int i = 0; i <= 17 ; i++)
            grid.getColumnConstraints().add(new ColumnConstraints(width));
        for (int i = 0; i <= 3; i++)
            grid.getRowConstraints().add(new RowConstraints(height));

        Button button = new Button("Start symulacji");
        grid.add(button, 12, 0, 3, 2);

        Label label = new Label("       Wprowadz directions");
        grid.add(label, 1, 0, 4, 1);


        TextField textField = new TextField();
        grid.add(textField, 1, 1, 4, 1);

        Label label2 = new Label("       Wprowadz moveDelay w [ms]");
        grid.add(label2, 6, 0, 5, 1);


        TextField textField2 = new TextField();
        grid.add(textField2, 6, 1, 5, 1);

        button.setOnAction(actionEvent ->
        {
            if (!textField2.getText().equals(""))
                ((SimulationEngine)engine).setMoveDelay(Integer.parseInt( textField2.getText()));
            if (!textField.getText().equals(""))
                ((SimulationEngine)engine).setDirections(new OptionsParser().parse(textField.getText()));
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });

    }



}
