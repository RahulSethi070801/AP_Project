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

import java.io.Serializable;

public class HorizontalLine extends Obstacle implements Blast, Serializable
{
//    Group root;
    transient Line line1, line2, line3, line4;
    transient TranslateTransition translateTransition1;
    transient TranslateTransition translateTransition2;
    transient TranslateTransition translateTransition3;
    transient TranslateTransition translateTransition4;

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

            if (isCollide(ball, (Shape)root.getChildren().get(i)) && ((Shape) root.getChildren().get(i)).getStroke().equals(ball.getFill()))
            {
                return true;
            }

        }
        return false;
    }


    public void show(long y, long difficulty)
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
        this.y = y;
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

        root = new Group();
        root.getChildren().addAll(line1, line2, line3, line4);
        addTransition();
        return root;
    }
    public void addTransition()
    {

        translateTransition1 = new TranslateTransition();
        translateTransition1.setDuration(Duration.millis(5000));
        translateTransition1.setNode(line1);
        translateTransition1.setByX(2000);
        translateTransition1.setCycleCount(Timeline.INDEFINITE);
        translateTransition1.setAutoReverse(false);
        translateTransition1.setInterpolator(Interpolator.LINEAR);
        translateTransition1.play();

        translateTransition2 = new TranslateTransition();
        translateTransition2.setDuration(Duration.millis(5000));
        translateTransition2.setNode(line2);
        translateTransition2.setByX(2000);
        translateTransition2.setCycleCount(Timeline.INDEFINITE);
        translateTransition2.setAutoReverse(false);
        translateTransition2.setInterpolator(Interpolator.LINEAR);
        translateTransition2.play();

        translateTransition3 = new TranslateTransition();
        translateTransition3.setDuration(Duration.millis(5000));
        translateTransition3.setNode(line3);
        translateTransition3.setByX(2000);
        translateTransition3.setCycleCount(Timeline.INDEFINITE);
        translateTransition3.setAutoReverse(false);
        translateTransition3.setInterpolator(Interpolator.LINEAR);
        translateTransition3.play();

        translateTransition4 = new TranslateTransition();
        translateTransition4.setDuration(Duration.millis(5000));
        translateTransition4.setNode(line4);
        translateTransition4.setByX(2000);
        translateTransition4.setCycleCount(Timeline.INDEFINITE);
        translateTransition4.setAutoReverse(false);
        translateTransition4.setInterpolator(Interpolator.LINEAR);
        translateTransition4.play();

    }
    
    public void showSaved(long y)
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
        this.root.getLayoutY();
    }

    public Group makeOneLineSaved(double x, long y)
    {
        line1 = new Line(x-400, 400-y, x-200, 400-y);
        line1.setStrokeWidth(10);
        line2 = new Line(x-200, 400-y, x, 400-y);
        line2.setStrokeWidth(10);
        line3 = new Line(x, 400-y, x+200, 400-y);
        line3.setStrokeWidth(10);
        line4 = new Line(x+200, 400-y, x+400, 400-y);
        line4.setStrokeWidth(10);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

        Group root = new Group();
        root.getChildren().addAll(line1, line2, line3, line4);

        addTransition();

        return root;
    }
    public void setLayoutY(double y)
    {
        this.y = y;
        this.root.setLayoutY(y);
    }
    public void setLayoutX(double x)
    {
        this.root.setLayoutX(x);
    }
    public double getLayoutY()
    {
        this.y = root.getLayoutY();
        return this.root.getLayoutY();
    }
    public double getLayoutX()
    {
        return this.root.getLayoutX();
    }
    public void increaseDifficulty(long difficulty)
    {
        translateTransition1.setDuration(Duration.millis(duration-difficulty));
        translateTransition2.setDuration(Duration.millis(duration-difficulty));
        translateTransition3.setDuration(Duration.millis(duration-difficulty));
        translateTransition4.setDuration(Duration.millis(duration-difficulty));
        duration-=difficulty;
    }
}
