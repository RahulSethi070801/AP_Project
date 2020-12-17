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
class FunModeBanner
{
    private Group root;

    FunModeBanner(){
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
                850.0, 630.0,
                650.0, 630.0,
                650.0, 680.0,
                850.0, 680.0,
        });
        rectangle.setFill(Color.GREEN);
        root.getChildren().add(rectangle);

        Polygon t1 = new Polygon();
        t1.getPoints().addAll(new Double[]{
                850.0, 630.0,
                835.0, 655.0,
                850.0, 680.0,
        });
        t1.setFill(Color.rgb(0, 0, 0));
        root.getChildren().add(t1);

        Polygon t2 = new Polygon();
        t2.getPoints().addAll(new Double[]{
                650.0, 630.0,
                665.0, 655.0,
                650.0, 680.0,
        });
        t2.setFill(Color.rgb(0, 0, 0));
        root.getChildren().add(t2);

        Text t = new Text (693, 660, "FUN MODE");
        t.setFont(Font.font ("Comic Sans MS", 17));
        t.setFill(Color.WHITE);
        root.getChildren().add(t);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                //Main.stage2.show();
                new GameRace();
            }
        };
        //Registering the event filter
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}
