package sample;

/*
2 concentric rings
*/

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
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

import java.io.Serializable;
import java.util.Random;


public class ConcentricCircles extends Obstacle implements Blast, Serializable
{
//    Group root;
    transient Shape shape1, shape2, shape3, shape4, shape5, shape6, shape7, shape8;


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

    public void explode()
    {
        final int size = 400;
        final Rectangle[] rectangles = new Rectangle[size];
        final long[] delays = new long[size];
        final double[] angles = new double[size];
        final double duration = Duration.seconds(3).toSeconds()*1000000;
        final Random random = new Random();

        for (int i = 0; i < size; i++) {
            rectangles[i] = new Rectangle(5, 5, Color.hsb(random.nextInt(360), 1, 1));
            delays[i] = (long) (Math.random()*duration);
            angles[i] = 2 * Math.PI * random.nextDouble();
        }
        show(100);

        new AnimationTimer() {
            @Override
            public void handle(long now) {

                final double width = 0.5 * 1200;//stage.getWidth();
                final double height = 0.5 * 800;//stage.getHeight();
                final double radius = Math.sqrt(2) * Math.max(width, height);

                for (int i = 0; i < size; i++) {
                    Rectangle r = rectangles[i];
                    double angle = angles[i];
                    double t = (now - delays[i]) % duration;
                    double d = t*radius/duration;

                    r.setOpacity((duration - t)/(double)duration);
                    r.setTranslateX(Math.cos(angle)*d + width);
                    r.setTranslateY(Math.sin(angle)*d + height);
                }
                root.getChildren().add(new Group(rectangles));
            }
        }.start();


    }

    public void showSaved(long y)
    {
        show(y-400);
    }
    public void show(long y)
    {
        Arc arc11 = new Arc(700, 400+y, 150, 150, 0, 90);
        arc11.setType(ArcType.ROUND);

        Arc arc12 = new Arc(700, 400+y, 130, 130, 0, 90);
        arc12.setType(ArcType.ROUND);

        Arc arc13 = new Arc(700, 400+y, 110, 110, 0, 90);
        arc13.setType(ArcType.ROUND);

        Arc arc14 = new Arc(700, 400+y, 90, 90, 0, 90);
        arc14.setType(ArcType.ROUND);

        Arc arc21 = new Arc(700, 400+y, 150, 150, 90, 90);
        arc21.setType(ArcType.ROUND);

        Arc arc22 = new Arc(700, 400+y, 130, 130, 90, 90);
        arc22.setType(ArcType.ROUND);

        Arc arc23 = new Arc(700, 400+y, 110, 110, 90, 90);
        arc23.setType(ArcType.ROUND);

        Arc arc24 = new Arc(700, 400+y, 90, 90, 90, 90);
        arc24.setType(ArcType.ROUND);

        Arc arc31 = new Arc(700, 400+y, 150, 150, 180, 90);
        arc31.setType(ArcType.ROUND);

        Arc arc32 = new Arc(700, 400+y, 130, 130, 180, 90);
        arc32.setType(ArcType.ROUND);

        Arc arc33 = new Arc(700, 400+y, 110, 110, 180, 90);
        arc33.setType(ArcType.ROUND);

        Arc arc34 = new Arc(700, 400+y, 90, 90, 180, 90);
        arc34.setType(ArcType.ROUND);

        Arc arc41 = new Arc(700, 400+y, 150, 150, 270, 90);
        arc41.setType(ArcType.ROUND);

        Arc arc42 = new Arc(700, 400+y, 130, 130, 270, 90);
        arc42.setType(ArcType.ROUND);

        Arc arc43 = new Arc(700, 400+y, 110, 110, 270, 90);
        arc43.setType(ArcType.ROUND);

        Arc arc44 = new Arc(700, 400+y, 90, 90, 270, 90);
        arc44.setType(ArcType.ROUND);

        shape1 = Shape.subtract(arc11, arc12);
        shape1.setFill(Color.rgb(144, 13, 255));
        shape2 = Shape.subtract(arc21, arc22);
        shape2.setFill(Color.rgb (250, 225, 0));
        shape3 = Shape.subtract(arc31, arc32);
        shape3.setFill(Color.rgb(50, 219, 240));
        shape4 = Shape.subtract(arc41, arc42);
        shape4.setFill(Color.rgb(255, 1, 129));

        shape5 = Shape.subtract(arc13, arc14);
        shape5.setFill(Color.rgb(144, 13, 255));
        shape6 = Shape.subtract(arc23, arc24);
        shape6.setFill(Color.rgb (250, 225, 0));
        shape7 = Shape.subtract(arc33, arc34);
        shape7.setFill(Color.rgb(50, 219, 240));
        shape8 = Shape.subtract(arc43, arc44);
        shape8.setFill(Color.rgb(255, 1, 129));

        this.root = new Group();
        root.getChildren().addAll(shape1,shape2,shape3,shape4, shape5, shape6, shape7, shape8);

        this.y = y;
        rotateTransition = new RotateTransition();
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setDuration(Duration.millis(5000));
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setNode(root);
        rotateTransition.play();
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
        this.y = this.root.getLayoutY();
        return this.root.getLayoutY();
    }
    public double getLayoutX()
    {
        return this.root.getLayoutX();
    }
}
