package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.animation.RotateTransition;
import javafx.animation.Interpolator;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;

import java.io.FileNotFoundException;
import java.util.*;
class GameModesBanner implements Display
{
    private Group root;

    GameModesBanner(){
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public void show()
    {
        root = new Group();

        Polygon rectangle = new Polygon();
        rectangle.getPoints().addAll(new Double[]{
            850.0, 710.0,
            650.0, 710.0,
            650.0, 760.0,
            850.0, 760.0,
        });
        rectangle.setFill(Color.BLUE);
        root.getChildren().add(rectangle);

        Polygon t1 = new Polygon();
        t1.getPoints().addAll(new Double[]{
            850.0, 710.0,
            835.0, 735.0,
            850.0, 760.0,
        });
        t1.setFill(Color.rgb(0, 0, 0));
        root.getChildren().add(t1);

        Polygon t2 = new Polygon();
        t2.getPoints().addAll(new Double[]{
            650.0, 710.0,
            665.0, 735.0,
            650.0, 760.0,
        });
        t2.setFill(Color.rgb(0, 0, 0));
        root.getChildren().add(t2);

        Text t = new Text (693, 740, "SAVED GAMES");
        t.setFont(Font.font ("Comic Sans MS", 17));
        t.setFill(Color.WHITE);
        root.getChildren().add(t);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                try {
                    new SavedGames();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };
        //Registering the event filter
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}
