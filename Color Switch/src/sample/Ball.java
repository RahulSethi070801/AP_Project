package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Random;

public class Ball
{
    private transient Group root;
    private transient Circle ball;
    private transient Color color;
    private double y;
    private double x;
    private String colorString;

    Ball(double x, double y)
    {
        this.y = y;
        this.x = x;
    }

    Ball()
    {
        this.x = 688;
        this.y = 700;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public static boolean isCollide(Circle x, Group y)
    {
        Bounds RectA = x.localToScene(x.getBoundsInLocal());
        Bounds RectB = y.localToScene(y.getBoundsInLocal());

        return RectB.intersects(RectA);
    }

    public Circle show() throws FileNotFoundException
    {

        root = new Group();

        ball = new Circle(10, Color.rgb(144, 13, 255));
        ball.relocate(x, y);

        root.getChildren().add(this.ball);
        this.y = root.getLayoutY();

        return ball;
    }

    public void setLayoutY(double y) // value to be added passed as parameter
    {
        this.y=this.ball.getLayoutY()+y;
        this.ball.setLayoutY(this.ball.getLayoutY()+y);
    }

    public void setLayY(double y) // value to be set is passed as parameter
    {
        this.y=y;
        this.ball.setLayoutY(y);
    }

    public double getLayY()
    {
        this.y=this.ball.getLayoutY();
        return this.ball.getLayoutY();
    }

    public void setFill(Color color)
    {
        this.ball.setFill(color);
    }

    public Bounds localToScene()
    {
        return this.ball.localToScene(this.ball.getBoundsInLocal());
    }

    public Object getFill() {
        return this.ball.getFill();
    }
}