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


class Triangle extends Obstacle
{
    Group root;
    Line line1, line2, line3;

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
    }
    public void show()
    {
        Line line1 = new Line(200, 200, 376, 301.734);
        line1.setStrokeWidth(5);
        Line line2 = new Line(200, 200, 376, 98.266);
        line2.setStrokeWidth(5);
        Line line3 = new Line(376, 301.734, 376, 98.266);
        line3.setStrokeWidth(5);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));


        root = new Group(line2, line1, line3);
        //root.getChildren().addAll(line1, line2, line3);

        Rotate r = new Rotate();
        root.getTransforms().add(r);
        r.setPivotX(317.3);
        r.setPivotY(200);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                r.setAngle(r.getAngle()+2);
            }
        };
        timer.start();
    }

}