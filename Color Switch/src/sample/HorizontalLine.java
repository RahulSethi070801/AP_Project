package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.Timeline;

public class HorizontalLine extends Obstacle
{
//    Group root;
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
                {}
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line2))
        {
            if (ball.getFill().equals(line2.getStroke()))
                {}
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line3))
        {
            if (ball.getFill().equals(line3.getStroke()))
                {}
            else
                System.out.println("blast");
        }
        if (isCollide(ball, line4))
        {
            if (ball.getFill().equals(line4.getStroke()))
                {}
            else
                System.out.println("blast");
        }
    }

    public void show(long y)
    {
        double X = -8000;
        Group figure = new Group();

        for(int i=0; i<100; i++)
        {
            Group oneLine;
            oneLine = makeOneLine(X+=800, y);
            figure.getChildren().add(oneLine);
        }
        root = figure;
    }

    public Group makeOneLine(double x, long y)
    {
        line1 = new Line(x-400, 400+y, x-200, 400+y);
        line1.setStrokeWidth(10);
        line2 = new Line(x-200, 400+y, x, 400+y);
        line2.setStrokeWidth(10);
        line3 = new Line(x, 400+y, x+200, 400+y);
        line3.setStrokeWidth(10);
        line4 = new Line(x+200, 400+y, x+400, 400+y);
        line4.setStrokeWidth(10);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

        Group root = new Group(line1, line2, line3, line4);

        TranslateTransition translateTransition1 = new TranslateTransition();
        translateTransition1.setDuration(Duration.millis(5000));
        translateTransition1.setNode(line1);
        translateTransition1.setByX(2000);
        translateTransition1.setCycleCount(Timeline.INDEFINITE);
        translateTransition1.setAutoReverse(false);
        translateTransition1.setInterpolator(Interpolator.LINEAR);
        translateTransition1.play();

        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setDuration(Duration.millis(5000));
        translateTransition2.setNode(line2);
        translateTransition2.setByX(2000);
        translateTransition2.setCycleCount(Timeline.INDEFINITE);
        translateTransition2.setAutoReverse(false);
        translateTransition2.setInterpolator(Interpolator.LINEAR);
        translateTransition2.play();

        TranslateTransition translateTransition3 = new TranslateTransition();
        translateTransition3.setDuration(Duration.millis(5000));
        translateTransition3.setNode(line3);
        translateTransition3.setByX(2000);
        translateTransition3.setCycleCount(Timeline.INDEFINITE);
        translateTransition3.setAutoReverse(false);
        translateTransition3.setInterpolator(Interpolator.LINEAR);
        translateTransition3.play();

        TranslateTransition translateTransition4 = new TranslateTransition();
        translateTransition4.setDuration(Duration.millis(5000));
        translateTransition4.setNode(line4);
        translateTransition4.setByX(2000);
        translateTransition4.setCycleCount(Timeline.INDEFINITE);
        translateTransition4.setAutoReverse(false);
        translateTransition4.setInterpolator(Interpolator.LINEAR);
        translateTransition4.play();


        return root;
    }
    public void setLayoutY(double y)
    {
        this.root.setLayoutY(y);
    }
    public void setLayoutX(double x)
    {
        this.root.setLayoutX(x);
    }
    public double getLayoutY()
    {
        return this.root.getLayoutY();
    }
    public double getLayoutX()
    {
        return this.root.getLayoutX();
    }
}
