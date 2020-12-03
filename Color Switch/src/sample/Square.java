package sample;
/*
    Square obstacle
*/
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;

class Square extends Obstacle
{
    Group root;
    Line line1, line2, line3, line4;
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

        System.out.println("square");return this.root;
    }

//    public static boolean isCollide(Circle x, Line y)
//    {
//        Bounds RectA = x.localToScene(x.getBoundsInParent());
//        Bounds RectB = y.localToScene(y.getBoundsInParent());
//        return RectA.intersects(RectB);
//    }

    public static boolean isCollide(Circle x, Line y)
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

    public void blast(Circle ball)
    {
        System.out.println(ball);
        System.out.println(line1);
        if (isCollide(ball, line1))
        {
//            System.out.println(ball.getColor());
//            System.out.println(shape1.getFill());
            if (ball.getFill().equals(line1.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line2))
        {
//            System.out.println(ball.getColor());
//            System.out.println(shape2.getFill());
            if (ball.getFill().equals(line2.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line3))
        {
//            System.out.println(ball.getColor());
//            System.out.println(shape3.getFill());
            if (ball.getFill().equals(line3.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line4))
        {
//            System.out.println(ball.getColor());
//            System.out.println(shape4.getFill());
            if (ball.getFill().equals(line4.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
    }

    public void show(long y)
    {

        line1 = new Line(550, 350+y, 750, 550+y);
        line1.setStrokeWidth(15);
        line1.setFill(null);
        line2 = new Line(550, 350+y, 750, 150+y);
        line2.setStrokeWidth(15);
        line2.setFill(null);
        line3 = new Line(750, 550+y, 950, 350+y);
        line3.setStrokeWidth(15);
        line3.setFill(null);
        line4 = new Line(750, 150+y, 950, 350+y);
        line4.setStrokeWidth(15);
        line4.setFill(null);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

        this.root = new Group(line1, line2, line3, line4);

        System.out.println(root);
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
