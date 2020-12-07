package sample;

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

public class Plus extends Obstacle
{
    Group root;
    Line line1, line2, line3, line4;

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public static boolean isCollide(Circle x, Line y)
    {
        Shape intersect = Shape.intersect(x,y);
        boolean b = false;
        if (intersect.getBoundsInLocal().getWidth() != -1)
        {
            b = true;
        }
        return b;
    }

    public void blast(Circle ball)
    {
        if (isCollide(ball, line1))
        {
            if (ball.getFill().equals(line1.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line2))
        {
            if (ball.getFill().equals(line2.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line3))
        {
            if (ball.getFill().equals(line3.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line4))
        {
            if (ball.getFill().equals(line4.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
}

    public void show(long y)
    {
        line1 = new Line(100+150, 200+y, 200+150, 200+y);
        line1.setStrokeWidth(10);
        line1.setFill(null);
        line2 = new Line(200+150, 200+y, 300+150, 200+y);
        line2.setStrokeWidth(10);
        line2.setFill(null);
        line3 = new Line(200+150, 200+y, 200+150, 300+y);
        line3.setStrokeWidth(10);
        line3.setFill(null);
        line4 = new Line(200+150, 200+y, 200+150, 100+y);
        line4.setStrokeWidth(10);
        line4.setFill(null);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

        root = new Group(line1, line2, line3, line4);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(5000));
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();
    }
}

