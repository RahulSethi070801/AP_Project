package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.Random;

public abstract class Obstacle implements Serializable
{
    protected double speed;
    protected String colors[] = { "Red", "Blue", "Pink", "Yellow"};
    protected long xcentre;
    protected long ycentre;
    protected double thickness;
    protected Group root;
    protected RotateTransition rotateTransition;
    protected long duration = 5000;
    public void move()
    {

    }

    public double getSpeed()
    {
        return this.speed;
    }

    public double getThickness() {
        return thickness;
    }

    public long getXcentre() {
        return xcentre;
    }

    public long getYcentre() {
        return ycentre;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setYcentre(long y) {
        this.ycentre = ycentre;
    }

    public void setXcentre(long x) {
        this.xcentre = xcentre;
    }

    public void show(long y)
    {

    }
    public void setLayoutY(double y)
    {
        this.root.setLayoutY(y);
    }
    public void setLayoutX(double x)
    {
        this.root.setLayoutX(x);
    }
    public double getLayoutY()
    {
        return this.root.getLayoutY();
    }
    public double getLayoutX()
    {
        return this.root.getLayoutX();
    }
    public Group getRoot()
    {
        //System.out.println("asdas");
        return new Group();
    }

//    public void explode()
//    {
//        final int size = 400;
//        final Rectangle[] rectangles = new Rectangle[size];
//        final long[] delays = new long[size];
//        final double[] angles = new double[size];
//        final double duration = Duration.seconds(3).toSeconds()*1000000;
//        final Random random = new Random();
//
//        for (int i = 0; i < size; i++) {
//            rectangles[i] = new Rectangle(5, 5, Color.hsb(random.nextInt(360), 1, 1));
//            delays[i] = (long) (Math.random()*duration);
//            angles[i] = 2 * Math.PI * random.nextDouble();
//        }
////        stage.setScene(new Scene(new Pane(rectangles), 500, 500, Color.BLACK));
////        stage.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.ESCAPE), () -> System.exit(0));
////        stage.show();
//
////        Group root1 = new Group(rectangles);
////        Scene scene3 = new Scene(root1, 1200, 800, Color.BLACK);
////        Main.stage.setScene(scene3);
////        Main.stage.setFullScreen(true);
//        //scene3.getAccelerators().put(new KeyCodeCombination(KeyCode.ESCAPE), () -> System.exit(0));
//        show(100);
//        //root.getChildren().add(root1);
//
//        new AnimationTimer() {
//            int count = 0;
//            @Override
//            public void handle(long now) {
//                count++;
//                if (count == 100000)
//                    super.stop();
//
//                final double width = 0.5 * 1200;//stage.getWidth();
//                final double height = 0.5 * 800;//stage.getHeight();
//                final double radius = Math.sqrt(2) * Math.max(width, height);
//
//                for (int i = 0; i < size; i++) {
//                    Rectangle r = rectangles[i];
//                    double angle = angles[i];
//                    double t = (now - delays[i]) % duration;
//                    double d = t*radius/duration;
//
//                    r.setOpacity((duration - t)/(double)duration);
//                    r.setTranslateX(Math.cos(angle)*d + width);
//                    r.setTranslateY(Math.sin(angle)*d + height);
//                }
//                root.getChildren().add(new Group(rectangles));
//            }
//        }.start();
//
////        Group root1 = new Group(rectangles);
////        Scene scene3 = new Scene(root1, 1200, 800, Color.BLACK);
////        Main.stage.setScene(scene3);
////        Main.stage.setFullScreen(true);
//    }

    public abstract boolean blast(Circle ball_c);


    public void increaseDifficulty(long difficulty)
    {
        rotateTransition.setDuration(Duration.millis(duration-difficulty));
    }
//    public boolean blast(Circle ball_c) {
//        return false;
//    }
}

