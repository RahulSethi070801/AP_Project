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

import java.util.Random;


class Triangle extends Obstacle implements Blast
{
//    Group root;
    Line line1, line2, line3;

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
        System.out.println("Tri");
        return root;
    }

    public static boolean isCollide(Circle x, Shape y)
    {
//        System.out.println(y);
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

//    public void blast(Circle ball)
//    {
////        System.out.println(ball);
////        System.out.println(line1);
////        System.out.println(line2);
////        System.out.println(line3);
//        if (isCollide(ball, line1))
//        {
////            System.out.println(ball.getColor());
////            System.out.println(shape1.getFill());
//            if (ball.getFill().equals(line1.getStroke()))
//                System.out.println("same color");
//            else
//            {System.exit(0);}
//        }
//        if (isCollide(ball, line2))
//        {
////            System.out.println(ball.getColor());
////            System.out.println(shape2.getFill());
//            if (ball.getFill().equals(line2.getStroke()))
//                System.out.println("same color");
//            else
//            {System.exit(0);}
//        }
//        if (isCollide(ball, line3))
//        {
////            System.out.println(ball.getColor());
////            System.out.println(shape3.getFill());
//            if (ball.getFill().equals(line3.getStroke()))
//                System.out.println("same color");
//            else
//            {System.exit(0);}
//        }
//    }

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

    public void show( long y)
    {
        line1 = new Line(200+380, 200+y+200, 376+380, 301.734+y+200);
        line1.setStrokeWidth(10);
        line1.setFill(null);
        line2 = new Line(200+380, 200+y+200, 376+380, 98.266+y+200);
        line2.setStrokeWidth(10);
        line2.setFill(null);
        line3 = new Line(376+380, 301.734+y+200, 376+380, 98.266+y+200);
        line3.setStrokeWidth(10);
        line3.setFill(null);

        line1.setStroke(Color.rgb(144, 13, 255));
        line2.setStroke(Color.rgb (255, 1, 129));
        line3.setStroke(Color.rgb(50, 219, 240));


        root = new Group();
        root.getChildren().addAll(line1, line2, line3);

        Rotate r = new Rotate();
        root.getTransforms().add(r);
        r.setPivotX(317.3+380);
        r.setPivotY(200+y+200);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                r.setAngle(r.getAngle()+2);
            }
        };
        timer.start();
    }

}
