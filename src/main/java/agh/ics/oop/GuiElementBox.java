package agh.ics.oop;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox
{
    public VBox vbox = new VBox();

    public GuiElementBox(IMapElement element) throws FileNotFoundException
    {
        if (element == null)
        {
            Label label = new Label("");
            vbox.getChildren().addAll(label);
        }
        else
        {
            Image image = new Image(new FileInputStream(element.getPath()));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            if(element instanceof Animal)
            {
                Label label = new Label(element.getPosition().toString());
                vbox.getChildren().addAll(imageView, label);
            }
            else
            {
                imageView.setFitHeight(25);
                imageView.setFitWidth(25);
                vbox.getChildren().addAll(imageView);
            }
            vbox.setAlignment(Pos.CENTER);
        }


    }
}
