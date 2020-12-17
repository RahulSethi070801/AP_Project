package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.sql.Time;
import java.util.Random;


class Ring extends Obstacle implements Blast
{
//    Group root;
    private transient Shape shape1, shape2, shape3, shape4;
    private transient Arc arc12, arc22, arc32, arc42;

    public Ring()
    {
        this.root= new Group();
    }

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

            if (isCollide(ball, (Shape)root.getChildren().get(i)) && !((Shape) root.getChildren().get(i)).getFill().equals(ball.getFill()))
            {
                return true;
            }

        }
        return false;
    }

    public void show(long y, long difficulty)
    {
        Arc arc11 = new Arc(700, 400+y, 110, 110, 0, 90);
        arc11.setType(ArcType.ROUND);
        arc11.setFill(Color.VIOLET);
        arc12 = new Arc(700, 400+y, 90, 90, 0, 90);
        arc12.setType(ArcType.ROUND);
        arc12.setFill(Color.VIOLET);


        Arc arc21 = new Arc(700, 400+y, 110, 110, 90, 90);
        arc21.setType(ArcType.ROUND);
        arc21.setFill(Color.BLUE);
        arc22 = new Arc(700, 400+y, 90, 90, 90, 90);
        arc22.setType(ArcType.ROUND);
        arc22.setFill(Color.BLUE);

        Arc arc31 = new Arc(700, 400+y, 110, 110, 180, 90);
        arc31.setType(ArcType.ROUND);
        arc31.setFill(Color.RED);
        arc32 = new Arc(700, 400+y, 90, 90, 180, 90);
        arc32.setType(ArcType.ROUND);
        arc32.setFill(Color.RED);

        Arc arc41 = new Arc(700, 400+y, 110, 110, 270, 90);
        arc41.setType(ArcType.ROUND);
        arc41.setFill(Color.YELLOW);
        arc42 = new Arc(700, 400+y, 90, 90, 270, 90);
        arc42.setType(ArcType.ROUND);
        arc42.setFill(Color.YELLOW);

        shape1 = Shape.subtract(arc11, arc12);
        shape1.setFill(Color.rgb(144, 13, 255));
        shape2 = Shape.subtract(arc21, arc22);
        shape2.setFill(Color.rgb (250, 225, 0));
        shape3 = Shape.subtract(arc31, arc32);
        shape3.setFill(Color.rgb(50, 219, 240));
        shape4 = Shape.subtract(arc41, arc42);
        shape4.setFill(Color.rgb(255, 1, 129));

        root = new Group();
        root.getChildren().addAll(shape1,shape2,shape3,shape4);

        this.y = y;

        rotateTransition = new RotateTransition();
        increaseDifficulty(rotateTransition, difficulty);
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();

        return ;

    }

    public void increaseDifficulty(RotateTransition rt,  long difficulty)
    {
        rt.setDuration(Duration.millis(8000-difficulty));
    }
}
