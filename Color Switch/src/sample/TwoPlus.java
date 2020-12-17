package sample;

import javafx.animation.AnimationTimer;
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

import java.io.Serializable;
import java.util.Random;

public class TwoPlus extends Obstacle implements Blast, Serializable
{
//    Group root;
    private transient Line line1, line2, line3, line4, line5, line6, line7, line8;
    private transient RotateTransition rotateTransition1;

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
                if (isCollide(ball, (Shape)temp.getChildren().get(j)) && !((Shape) temp.getChildren().get(j)).getStroke().equals(ball.getFill()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void show(long y, long difficulty)
    {
        line1 = new Line(100+400, 400+y, 200+400, 400+y);
        line1.setStrokeWidth(20);
        line2 = new Line(200+400, 400+y, 300+400, 400+y);
        line2.setStrokeWidth(20);
        line3 = new Line(200+400, 400+y, 200+400, 500+y);
        line3.setStrokeWidth(20);
        line4 = new Line(200+400, 400+y, 200+400, 300+y);
        line4.setStrokeWidth(20);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

        line5 = new Line(400+400, 400+y, 500+400, 400+y);
        line5.setStrokeWidth(20);
        line6 = new Line(400+400, 400+y, 300+400, 400+y);
        line6.setStrokeWidth(20);
        line7 = new Line(400+400, 400+y, 400+400, 500+y);
        line7.setStrokeWidth(20);
        line8 = new Line(400+400, 400+y, 400+400, 300+y);
        line8.setStrokeWidth(20);

        line5.setStroke(Color.rgb(144, 13, 255));
        line6.setStroke(Color.rgb (250, 225, 0));
        line7.setStroke(Color.rgb(50, 219, 240));
        line8.setStroke(Color.rgb(255, 1, 129));


        Group root1 = new Group();
        root1.getChildren().addAll(line1, line2, line3, line4);
        Group root2 = new Group();
        root2.getChildren().addAll(line5, line6, line7, line8);
        root = new Group();

        root.getChildren().add(root2);
        root.getChildren().add(root1);
        this.y = this.root.getLayoutY();

        addTransition(root1, root2, difficulty);

        this.y=y;
        //duration = 4000;
        
    }
    public void addTransition(Group root1, Group root2, long difficulty)
    {
        this.speed = (int)difficulty;
        rotateTransition = new RotateTransition();
        if (speed == 1)
            rotateTransition.setDuration(Duration.millis(6000));
        else if (speed == 2)
            rotateTransition.setDuration(Duration.millis(4500));
        else
            rotateTransition.setDuration(Duration.millis(3000));
        //increaseDifficulty(rotateTransition, difficulty);
        rotateTransition.setNode(root1);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();
    
        rotateTransition1 = new RotateTransition();
        if (speed == 1)
            rotateTransition1.setDuration(Duration.millis(6000));
        else if (speed == 2)
            rotateTransition1.setDuration(Duration.millis(4500));
        else
            rotateTransition1.setDuration(Duration.millis(3000));
        //increaseDifficulty(rotateTransition1, difficulty);
        rotateTransition1.setNode(root2);
        rotateTransition1.setByAngle(-360);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.play();
    }

//    public void increaseDifficulty(RotateTransition rt,  long difficulty)
//    {
//        rt.setDuration(Duration.millis(5000-difficulty));
//    }

}
