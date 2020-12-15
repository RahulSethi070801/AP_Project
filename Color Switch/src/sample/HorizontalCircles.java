package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.animation.RotateTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;

import java.io.Serializable;
import java.util.Random;

public class HorizontalCircles extends Obstacle implements Blast, Serializable
{
//    Group root;
    transient Shape shape1, shape2, shape3, shape4, shape5, shape6, shape7, shape8;

    transient RotateTransition rotateTransition1;

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
            Group temp= (Group)root.getChildren().get(i);
            for(int j=0; j<temp.getChildren().size(); j++)
            {
                if (isCollide(ball, (Shape)temp.getChildren().get(j)) && !((Shape) temp.getChildren().get(j)).getFill().equals(ball.getFill()))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void show(long y)
    {
        Arc arc11 = new Arc(570, 400+y, 130, 130, 0, 90);
        arc11.setType(ArcType.ROUND);
//        arc11.setFill(Color.VIOLET);
        Arc arc12 = new Arc(570, 400+y, 90, 90, 0, 90);
        arc12.setType(ArcType.ROUND);
//        arc12.setFill(Color.VIOLET);

        Arc arc21 = new Arc(570, 400+y, 130, 130, 90, 90);
        arc21.setType(ArcType.ROUND);
//        arc21.setFill(Color.BLUE);
        Arc arc22 = new Arc(570, 400+y, 90, 90, 90, 90);
        arc22.setType(ArcType.ROUND);
//        arc22.setFill(Color.BLUE);

        Arc arc31 = new Arc(570, 400+y, 130, 130, 180, 90);
        arc31.setType(ArcType.ROUND);
//        arc31.setFill(Color.RED);
        Arc arc32 = new Arc(570, 400+y, 90, 90, 180, 90);
        arc32.setType(ArcType.ROUND);
//        arc32.setFill(Color.RED);

        Arc arc41 = new Arc(570, 400+y, 130, 130, 270, 90);
        arc41.setType(ArcType.ROUND);
//        arc41.setFill(Color.YELLOW);
        Arc arc42 = new Arc(570, 400+y, 90, 90, 270, 90);
        arc42.setType(ArcType.ROUND);
//        arc42.setFill(Color.YELLOW);


        Arc arc51 = new Arc(830, 400+y, 130, 130, 90, 90);
        arc51.setType(ArcType.ROUND);
//        arc51.setFill(Color.VIOLET);
        Arc arc52 = new Arc(830, 400+y, 90, 90, 90, 90);
        arc52.setType(ArcType.ROUND);
//        arc52.setFill(Color.VIOLET);

        Arc arc61 = new Arc(830, 400+y, 130, 130, 0, 90);
        arc61.setType(ArcType.ROUND);
//        arc61.setFill(Color.BLUE);
        Arc arc62 = new Arc(830, 400+y, 90, 90, 0, 90);
        arc62.setType(ArcType.ROUND);
//        arc62.setFill(Color.BLUE);

        Arc arc71 = new Arc(830, 400+y, 130, 130, 270, 90);
        arc71.setType(ArcType.ROUND);
//        arc71.setFill(Color.RED);
        Arc arc72 = new Arc(830, 400+y, 90, 90, 270, 90);
        arc72.setType(ArcType.ROUND);
//        arc72.setFill(Color.RED);

        Arc arc81 = new Arc(830, 400+y, 130, 130, 180, 90);
        arc81.setType(ArcType.ROUND);
//        arc81.setFill(Color.YELLOW);
        Arc arc82 = new Arc(830, 400+y, 90, 90, 180, 90);
        arc82.setType(ArcType.ROUND);
//        arc82.setFill(Color.YELLOW);


        shape1 = Shape.subtract(arc11, arc12);
        shape1.setFill(Color.rgb(144, 13, 255));
        shape2 = Shape.subtract(arc21, arc22);
        shape2.setFill(Color.rgb (250, 225, 0));
        shape3 = Shape.subtract(arc31, arc32);
        shape3.setFill(Color.rgb(50, 219, 240));
        shape4 = Shape.subtract(arc41, arc42);
        shape4.setFill(Color.rgb(255, 1, 129));

        shape5 = Shape.subtract(arc51, arc52);
        shape5.setFill(Color.rgb(144, 13, 255));
        shape6 = Shape.subtract(arc61, arc62);
        shape6.setFill(Color.rgb (250, 225, 0));
        shape7 = Shape.subtract(arc71, arc72);
        shape7.setFill(Color.rgb(50, 219, 240));
        shape8 = Shape.subtract(arc81, arc82);
        shape8.setFill(Color.rgb(255, 1, 129));



        root = new Group();
        Group root1 = new Group();
        root1.getChildren().addAll(shape1, shape2, shape3, shape4);
        Group root2 = new Group();
        root2.getChildren().addAll(shape6, shape5, shape8, shape7);



        rotateTransition = new RotateTransition();
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setDuration(Duration.millis(8000));
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setNode(root1);
        rotateTransition.play();

        rotateTransition1 = new RotateTransition();
        rotateTransition1.setAxis(Rotate.Z_AXIS);
        rotateTransition1.setByAngle(-360);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setDuration(Duration.millis(8000));
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.setNode(root2);
        rotateTransition1.play();

        duration = 8000;
        root.getChildren().add(root1);
        root.getChildren().add(root2);
        this.y = y;
        root.setTranslateY(y);
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
        //     System.out.println(root+" hosri");
        //     System.out.println(this.y+" y");
        this.y = this.root.getLayoutY();
        return this.root.getLayoutY();
    }
    public double getLayoutX()
    {
        return this.root.getLayoutX();
    }
    public void increaseDifficulty(long difficulty)
    {
        rotateTransition.setDuration(Duration.millis(duration-difficulty));
        rotateTransition1.setDuration(Duration.millis(duration-difficulty));
    }
}
