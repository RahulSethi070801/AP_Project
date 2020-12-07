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

import java.util.Random;

public class HorizontalCircles extends Obstacle
{
    Group root;
    Shape shape1, shape2, shape3, shape4, shape5, shape6, shape7, shape8;


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

    public void blast(Circle ball)
    {
        if (isCollide(ball, shape1))
        {
            if (ball.getFill().equals(shape1.getFill()))
                {}
            else
                explode();
        }
        if (isCollide(ball, shape2))
        {
            if (ball.getFill().equals(shape2.getFill()))
                {}
            else
                explode();
        }
        if (isCollide(ball, shape3))
        {
            if (ball.getFill().equals(shape3.getFill()))
                {}
            else
                explode();
        }
        if (isCollide(ball, shape4))
        {
            if (ball.getFill().equals(shape4.getFill()))
                {}
            else
                explode();
        }
        if (isCollide(ball, shape5))
        {
            if (ball.getFill().equals(shape4.getFill()))
                {}
            else
                explode();
        }
        if (isCollide(ball, shape6))
        {
            if (ball.getFill().equals(shape4.getFill()))
                {}
            else
                explode();
        }
        if (isCollide(ball, shape7))
        {
            if (ball.getFill().equals(shape4.getFill()))
                {}
            else
                explode();
        }
        if (isCollide(ball, shape8))
        {
            if (ball.getFill().equals(shape4.getFill()))
                {}
            else
                explode();
        }
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
//        stage.setScene(new Scene(new Pane(rectangles), 500, 500, Color.BLACK));
//        stage.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.ESCAPE), () -> System.exit(0));
//        stage.show();

//        Group root1 = new Group(rectangles);
//        Scene scene3 = new Scene(root1, 1200, 800, Color.BLACK);
//        Main.stage.setScene(scene3);
//        Main.stage.setFullScreen(true);
        //scene3.getAccelerators().put(new KeyCodeCombination(KeyCode.ESCAPE), () -> System.exit(0));
        show(100);
        //root.getChildren().add(root1);

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

//        Group root1 = new Group(rectangles);
//        Scene scene3 = new Scene(root1, 1200, 800, Color.BLACK);
//        Main.stage.setScene(scene3);
//        Main.stage.setFullScreen(true);

    }

    public void show(long y)
    {
        Arc arc11 = new Arc(590, 400+y, 110, 110, 0, 90);
        arc11.setType(ArcType.ROUND);
        arc11.setFill(Color.VIOLET);
        Arc arc12 = new Arc(590, 400+y, 90, 90, 0, 90);
        arc12.setType(ArcType.ROUND);
        arc12.setFill(Color.VIOLET);

        Arc arc21 = new Arc(590, 400+y, 110, 110, 90, 90);
        arc21.setType(ArcType.ROUND);
        arc21.setFill(Color.BLUE);
        Arc arc22 = new Arc(590, 400+y, 90, 90, 90, 90);
        arc22.setType(ArcType.ROUND);
        arc22.setFill(Color.BLUE);

        Arc arc31 = new Arc(590, 400+y, 110, 110, 180, 90);
        arc31.setType(ArcType.ROUND);
        arc31.setFill(Color.RED);
        Arc arc32 = new Arc(590, 400+y, 90, 90, 180, 90);
        arc32.setType(ArcType.ROUND);
        arc32.setFill(Color.RED);

        Arc arc41 = new Arc(590, 400+y, 110, 110, 270, 90);
        arc41.setType(ArcType.ROUND);
        arc41.setFill(Color.YELLOW);
        Arc arc42 = new Arc(590, 400+y, 90, 90, 270, 90);
        arc42.setType(ArcType.ROUND);
        arc42.setFill(Color.YELLOW);


        Arc arc51 = new Arc(810, 400+y, 110, 110, 90, 90);
        arc51.setType(ArcType.ROUND);
        arc51.setFill(Color.VIOLET);
        Arc arc52 = new Arc(810, 400+y, 90, 90, 90, 90);
        arc52.setType(ArcType.ROUND);
        arc52.setFill(Color.VIOLET);

        Arc arc61 = new Arc(810, 400+y, 110, 110, 0, 90);
        arc61.setType(ArcType.ROUND);
        arc61.setFill(Color.BLUE);
        Arc arc62 = new Arc(810, 400+y, 90, 90, 0, 90);
        arc62.setType(ArcType.ROUND);
        arc62.setFill(Color.BLUE);

        Arc arc71 = new Arc(810, 400+y, 110, 110, 270, 90);
        arc71.setType(ArcType.ROUND);
        arc71.setFill(Color.RED);
        Arc arc72 = new Arc(810, 400+y, 90, 90, 270, 90);
        arc72.setType(ArcType.ROUND);
        arc72.setFill(Color.RED);

        Arc arc81 = new Arc(810, 400+y, 110, 110, 180, 90);
        arc81.setType(ArcType.ROUND);
        arc81.setFill(Color.YELLOW);
        Arc arc82 = new Arc(810, 400+y, 90, 90, 180, 90);
        arc82.setType(ArcType.ROUND);
        arc82.setFill(Color.YELLOW);


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
        Group root1 = new Group(shape1, shape2, shape3, shape4);
        Group root2 = new Group(shape6, shape5, shape8, shape7);

        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(5000));
        rotate.setAutoReverse(false);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(root1);
        rotate.play();

        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(-360);
        rotate1.setCycleCount(Timeline.INDEFINITE);
        rotate1.setDuration(Duration.millis(5000));
        rotate1.setAutoReverse(false);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setNode(root2);
        rotate1.play();

        root.getChildren().add(root1);
        root.getChildren().add(root2);
    }

}
