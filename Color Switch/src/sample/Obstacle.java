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
    // non-serializable objects
    transient protected Group root;
    transient protected RotateTransition rotateTransition;

    // serializable objects
    protected double speed;
    protected String colors[] = { "Red", "Blue", "Pink", "Yellow"};
    protected double x;
    protected double y;
    protected double xx=570.0;
    protected double yy;
    protected double thickness;
    protected long duration = 5000;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public abstract void show(long y, long difficulty);

    public void increaseDifficulty(RotateTransition rt,  long difficulty){
        
    }

    public abstract Group getRoot();

    public abstract boolean blast(Circle ball_c);

}

