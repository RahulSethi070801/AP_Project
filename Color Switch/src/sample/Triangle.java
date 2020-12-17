package sample;

/*
 Triangle obstacle
*/

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Random;


class Triangle extends Obstacle implements Blast, Serializable
{
//    Group root;
    private transient Line line1, line2, line3;

    public Triangle()
    {
        this.root = new Group();
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

            if (isCollide(ball, (Shape)root.getChildren().get(i)) && !((Shape) root.getChildren().get(i)).getStroke().equals(ball.getFill()))
            {
                return true;
            }

        }
        return false;
    }


    public void show( long y, long difficulty)
    {

        line1 = new Line(200+380, 200+y+200, 376+380, 301.734+y+200);
        line1.setStrokeWidth(10);
        line1.setFill(null);
        line1.setStroke(Color.rgb(144, 13, 255));

        line2 = new Line(200+380, 200+y+200, 376+380, 98.266+y+200);
        line2.setStrokeWidth(10);
        line2.setFill(null);
        line2.setStroke(Color.rgb (255, 1, 129));

        line3 = new Line(376+380, 301.734+y+200, 376+380, 98.266+y+200);
        line3.setStrokeWidth(10);
        line3.setFill(null);
        line3.setStroke(Color.rgb(50, 219, 240));

        root = new Group();
        root.getChildren().addAll(line1, line2, line3);

        Rotate r = new Rotate();
        root.getTransforms().add(r);
        r.setPivotX(317.3+380);
        r.setPivotY(200+y+200);

        this.y=y+400;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                r.setAngle(r.getAngle()+2);
            }
        };
        timer.start();
    }
    public void increaseDifficulty(long difficulty)
    {

    }

}
