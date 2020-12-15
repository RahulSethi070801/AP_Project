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
    transient Line line1, line2, line3, line4, line5, line6, line7, line8;
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
                if (isCollide(ball, (Shape)temp.getChildren().get(j)) && !((Shape) temp.getChildren().get(j)).getStroke().equals(ball.getFill()))
                {
                    return true;
                }
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
        line1 = new Line(100+400, 400+y, 200+400, 400+y);
        line1.setStrokeWidth(10);
        line2 = new Line(200+400, 400+y, 300+400, 400+y);
        line2.setStrokeWidth(10);
        line3 = new Line(200+400, 400+y, 200+400, 500+y);
        line3.setStrokeWidth(10);
        line4 = new Line(200+400, 400+y, 200+400, 300+y);
        line4.setStrokeWidth(10);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (250, 225, 0));
        line3.setStroke(Color.rgb(50, 219, 240));
        line4.setStroke(Color.rgb(255, 1, 129));

        line5 = new Line(400+400, 400+y, 500+400, 400+y);
        line5.setStrokeWidth(10);
        line6 = new Line(400+400, 400+y, 300+400, 400+y);
        line6.setStrokeWidth(10);
        line7 = new Line(400+400, 400+y, 400+400, 500+y);
        line7.setStrokeWidth(10);
        line8 = new Line(400+400, 400+y, 400+400, 300+y);
        line8.setStrokeWidth(10);

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

        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(4000));
        rotateTransition.setNode(root1);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();

        rotateTransition1 = new RotateTransition();
        rotateTransition1.setDuration(Duration.millis(4000));
        rotateTransition1.setNode(root2);
        rotateTransition1.setByAngle(-360);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.play();

        duration = 4000;

    }

    public void increaseDifficulty(long difficulty)
    {
        rotateTransition.setDuration(Duration.millis(duration-difficulty));
        rotateTransition1.setDuration(Duration.millis(duration-difficulty));
    }

}
