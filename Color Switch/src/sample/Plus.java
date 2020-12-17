package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Random;

public class Plus extends Obstacle implements Blast, Serializable
{
//    Group root;
    private transient Line line1, line2, line3, line4;

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public static boolean isCollide(Circle x, Shape y)
    {
        Shape intersect = Shape.intersect(x,y);
        boolean b = false;
        if (intersect.getBoundsInLocal().getWidth() != -1)
        {
            b = true;
        }
        return b;
    }

    @Override
    public boolean blast(Circle ball)
    {
        for(int i=0;i<root.getChildren().size();i++)
        {
            if (isCollide(ball, (Shape)root.getChildren().get(i)) && !((Shape) root.getChildren().get(i)).getStroke().equals(ball.getFill()))
            {
                return true;
            }
        }
        return false;
    }

    public void show(long y, long difficulty)
    {

        line1 = new Line(100+400, 400+y, 200+400, 400+y);
        line1.setStrokeWidth(20);
        line1.setFill(null);
        line1.setStroke(Color.rgb(144, 13, 255));

        line2 = new Line(200+400, 400+y, 300+400, 400+y);
        line2.setStrokeWidth(20);
        line2.setFill(null);
        line2.setStroke(Color.rgb (250, 225, 0));

        line3 = new Line(200+400, 400+y, 200+400, 500+y);
        line3.setStrokeWidth(20);
        line3.setFill(null);
        line3.setStroke(Color.rgb(50, 219, 240));

        line4 = new Line(200+400, 400+y, 200+400, 300+y);
        line4.setStrokeWidth(20);
        line4.setFill(null);
        line4.setStroke(Color.rgb(255, 1, 129));


        root = new Group();
        root.getChildren().addAll(line1, line2, line3, line4);

        this.y = y;
        rotateTransition = new RotateTransition();
        increaseDifficulty(rotateTransition, difficulty);
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();

        duration = 6000;
    }
    
    public void increaseDifficulty(RotateTransition rt,  long difficulty)
    {
        if(duration - difficulty > 0)
            rt.setDuration(Duration.millis(duration-difficulty));
    }

}

