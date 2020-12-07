package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class TwoPlus extends Obstacle
{
    Group root;
    Line line1, line2, line3, line4, line5, line6, line7, line8;

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
        if (isCollide(ball, line5))
        {
            if (ball.getFill().equals(line5.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line6))
        {
            if (ball.getFill().equals(line5.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line7))
        {
            if (ball.getFill().equals(line7.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line8))
        {
            if (ball.getFill().equals(line8.getStroke()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
    }

    public void show(long y)
    {
        line1 = new Line(100+400, 400+y, 200+400, 400+y);
        line1.setStrokeWidth(10);
        line2 = new Line(200+400, 400+y, 300+400, 400+y);
        line2.setStrokeWidth(10);
        line3 = new Line(200+400, 400+y, 200+400, 500+y);
        line3.setStrokeWidth(10);
        line4 = new Line(200+400, 400+y, 200+400, 300+y);
        line4.setStrokeWidth(10);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

        line5 = new Line(400+400, 400+y, 500+400, 400+y);
        line5.setStrokeWidth(10);
        line6 = new Line(400+400, 400+y, 300+400, 400+y);
        line6.setStrokeWidth(10);
        line7 = new Line(400+400, 400+y, 400+400, 500+y);
        line7.setStrokeWidth(10);
        line8 = new Line(400+400, 400+y, 400+400, 300+y);
        line8.setStrokeWidth(10);

        line5.setStroke(Color.rgb(144, 13, 255));
        line6.setStroke(Color.rgb (250, 225, 0));
        line7.setStroke(Color.rgb(50, 219, 240));
        line8.setStroke(Color.rgb(255, 1, 129));


        Group root1 = new Group(line1, line2, line3, line4);
        Group root2 = new Group(line5, line6, line7, line8);
        root = new Group();

        root.getChildren().add(root2);
        root.getChildren().add(root1);

        RotateTransition rotateTransition1 = new RotateTransition();
        rotateTransition1.setDuration(Duration.millis(4000));
        rotateTransition1.setNode(root1);
        rotateTransition1.setByAngle(360);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.play();

        RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setDuration(Duration.millis(4000));
        rotateTransition2.setNode(root2);
        rotateTransition2.setByAngle(-360);
        rotateTransition2.setCycleCount(Timeline.INDEFINITE);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.play();

    }
}
