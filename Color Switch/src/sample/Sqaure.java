package sample;
/*
    Square obstacle
*/
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
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
        Bounds RectA = x.localToScene(x.getBoundsInLocal());
        Bounds RectB = y.localToScene(y.getBoundsInLocal());
        return RectA.intersects(RectB);
    }
//    public static boolean isCollide(Circle x, Line y)
//    {
//        Bounds RectA = x.getBoundsInLocal();
//        Bounds RectB = y.getBoundsInLocal();
//        return RectA.intersects(RectB);
//    }

    public void blast(Circle ball)
    {

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

    public void show()
    {

        line1 = new Line(550, 350, 750, 550);
        line1.setStrokeWidth(10);
        line2 = new Line(550, 350, 750, 150);
        line2.setStrokeWidth(10);
        line3 = new Line(750, 550, 950, 350);
        line3.setStrokeWidth(10);
        line4 = new Line(750, 150, 950, 350);
        line4.setStrokeWidth(10);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

//        line1.setFill(Color.YELLOW);
//        line2.setFill(Color.GREEN);
//        line3.setFill(Color.CYAN);


        root = new Group(line1, line2, line3, line4);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(5000));
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();


    }

}
