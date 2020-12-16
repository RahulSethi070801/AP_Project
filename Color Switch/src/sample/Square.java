package sample;
/*
    Square obstacle
*/
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
//import java.time.Duration;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;

class Square extends Obstacle implements Blast, Serializable
{
//    Group root;
    transient Line line1, line2, line3, line4;
    public Square()
    {
        this.root = new Group();
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {

        //System.out.println("square");
        return this.root;
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
        //return x.getBoundsInParent().intersects(y.getBoundsInParent());
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

        line1 = new Line(500, 400+y, 700, 600+y);
        line1.setStrokeWidth(15);
        line1.setFill(null);
        line2 = new Line(500, 400+y, 700, 200+y);
        line2.setStrokeWidth(15);
        line2.setFill(null);
        line3 = new Line(700, 600+y, 900, 400+y);
        line3.setStrokeWidth(15);
        line3.setFill(null);
        line4 = new Line(700, 200+y, 900, 400+y);
        line4.setStrokeWidth(15);
        line4.setFill(null);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

        this.root = new Group();
        root.getChildren().addAll(line1, line2, line3, line4);

        this.y = y;
        // System.out.println(root);
        rotateTransition = new RotateTransition();
        // rotateTransition.setDuration(Duration.millis(5000));
        increaseDifficulty(rotateTransition, difficulty);
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();
    }
    public void increaseDifficulty(RotateTransition rt,  long difficulty)
    {
        rt.setDuration(Duration.millis(8000-difficulty));
        // rt.setDuration(Duration.millis(8000-difficulty));
        //duration-=difficulty;
    }
}
