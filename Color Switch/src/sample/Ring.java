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
    transient Shape shape1, shape2, shape3, shape4;
    transient Arc arc12, arc22, arc32, arc42;

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

//    public void blast(Circle ball)
//    {
//        //System.out.println("Ringggg");
//        if (isCollide(ball, shape1))
//        {
////            System.out.println(ball.getColor());
////            System.out.println(shape1.getFill());
//            if (ball.getFill().equals(shape1.getFill()))
//                {}
//            else
//            {System.exit(0);}
//                //explode();
//        }
//        if (isCollide(ball, shape2))
//        {
////            System.out.println(ball.getColor());
////            System.out.println(shape2.getFill());
//            if (ball.getFill().equals(shape2.getFill()))
//                {}
//            else
//            {System.exit(0);}
//                //explode();
//        }
//        if (isCollide(ball, shape3))
//        {
////            System.out.println(ball.getColor());
////            System.out.println(shape3.getFill());
//            if (ball.getFill().equals(shape3.getFill()))
//                {}
//            else
//            {System.exit(0);}
//        }
//        if (isCollide(ball, shape4))
//        {
////            System.out.println(ball.getColor());
////            System.out.println(shape4.getFill());
//            if (ball.getFill().equals(shape4.getFill()))
//                {}
//            else
//            {System.exit(0);}
//        }
//    }

    public void explode()
    {
        System.out.println("explode");
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

    public void showSaved(long y)
    {
        show(y-400);
    }
    public void show(long y)
    {
        Arc arc11 = new Arc(700, 400+y, 110, 110, 0, 90);
        arc11.setType(ArcType.ROUND);
        arc11.setFill(Color.VIOLET);
//        arc11.setFill(null);
        arc12 = new Arc(700, 400+y, 90, 90, 0, 90);
        arc12.setType(ArcType.ROUND);
        arc12.setFill(Color.VIOLET);
//        arc12.setFill(null);


        Arc arc21 = new Arc(700, 400+y, 110, 110, 90, 90);
        arc21.setType(ArcType.ROUND);
        arc21.setFill(Color.BLUE);
//        arc21.setFill(null);
        arc22 = new Arc(700, 400+y, 90, 90, 90, 90);
        arc22.setType(ArcType.ROUND);
        arc22.setFill(Color.BLUE);
//        arc22.setFill(null);

        Arc arc31 = new Arc(700, 400+y, 110, 110, 180, 90);
        arc31.setType(ArcType.ROUND);
        arc31.setFill(Color.RED);
//        arc31.setFill(null);
        arc32 = new Arc(700, 400+y, 90, 90, 180, 90);
        arc32.setType(ArcType.ROUND);
        arc32.setFill(Color.RED);
//        arc32.setFill(null);

        Arc arc41 = new Arc(700, 400+y, 110, 110, 270, 90);
        arc41.setType(ArcType.ROUND);
        arc41.setFill(Color.YELLOW);
//        arc41.setFill(null);
        arc42 = new Arc(700, 400+y, 90, 90, 270, 90);
        arc42.setType(ArcType.ROUND);
        arc42.setFill(Color.YELLOW);
//        arc42.setFill(null);

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

        this.y = this.root.getLayoutY();
        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(5000));
        rotateTransition.setNode(root);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.play();

        return ;

    }
    public double getLayoutY()
    {
        this.y = this.root.getLayoutY();
        return this.root.getLayoutY();
    }
    public void setLayoutY(double y)
    {
        this.y = y;
        this.root.setLayoutY(y);
    }
}
