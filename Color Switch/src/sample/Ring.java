package sample;

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
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;



class Ring extends Obstacle
{
    Group root;
    Shape shape1, shape2, shape3, shape4;
    Arc arc12, arc22, arc32, arc42;

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public static boolean isCollide(Ball x, Shape y)
    {
        Bounds RectA = x.localToScene();
        Bounds RectB = y.localToScene(y.getBoundsInLocal());
        return RectB.intersects(RectA);
    }

    public static boolean isCollide1(Ball x, Arc y)
    {
        Bounds RectA = x.localToScene();
        Bounds RectB = y.localToScene(y.getBoundsInLocal());

        return RectB.intersects(RectA);
    }

    public void blast(Ball ball)
    {
        if (isCollide(ball, shape1) && !isCollide1(ball, arc12))
        {
//            System.out.println(ball.getColor());
//            System.out.println(shape1.getFill());
            if (ball.getColor().equals(shape1.getFill()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, shape2) && !isCollide1(ball, arc22))
        {
//            System.out.println(ball.getColor());
//            System.out.println(shape2.getFill());
            if (ball.getColor().equals(shape2.getFill()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, shape3) && !isCollide1(ball, arc32))
        {
//            System.out.println(ball.getColor());
//            System.out.println(shape3.getFill());
            if (ball.getColor().equals(shape3.getFill()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
        if (isCollide(ball, shape4) && !isCollide1(ball, arc42))
        {
//            System.out.println(ball.getColor());
//            System.out.println(shape4.getFill());
            if (ball.getColor().equals(shape4.getFill()))
                System.out.println("same color");
            else
                System.out.println("blast");
        }
    }

    public Group show()
    {
        Arc arc11 = new Arc(700, 400, 110, 110, 0, 90);
        arc11.setType(ArcType.ROUND);
        arc11.setFill(Color.VIOLET);
        arc12 = new Arc(700, 400, 90, 90, 0, 90);
        arc12.setType(ArcType.ROUND);
        arc12.setFill(Color.VIOLET);


        Arc arc21 = new Arc(700, 400, 110, 110, 90, 90);
        arc21.setType(ArcType.ROUND);
        arc21.setFill(Color.BLUE);
        arc22 = new Arc(700, 400, 90, 90, 90, 90);
        arc22.setType(ArcType.ROUND);
        arc22.setFill(Color.BLUE);

        Arc arc31 = new Arc(700, 400, 110, 110, 180, 90);
        arc31.setType(ArcType.ROUND);
        arc31.setFill(Color.RED);
        arc32 = new Arc(700, 400, 90, 90, 180, 90);
        arc32.setType(ArcType.ROUND);
        arc32.setFill(Color.RED);

        Arc arc41 = new Arc(700, 400, 110, 110, 270, 90);
        arc41.setType(ArcType.ROUND);
        arc41.setFill(Color.YELLOW);
        arc42 = new Arc(700, 400, 90, 90, 270, 90);
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

        root = new Group(shape1,shape2,shape3,shape4);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(5000));
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(1000);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();

        return root;

    }
}
