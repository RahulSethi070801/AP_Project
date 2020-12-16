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
    protected double x;
    protected double y;
    protected long xcentre; 
    protected long ycentre;
    protected double thickness;
    transient protected Group root;
    transient protected RotateTransition rotateTransition;
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setYcentre(long y) {
        this.ycentre = ycentre;
    }

    public void setXcentre(long x) {
        this.xcentre = xcentre;
    }

    public void show(long y, long difficulty)
    {

    }
    public void showSaved(long y)
    {

    }
    public void increaseDifficulty(RotateTransition rt,  long difficulty){
        
    }
    public void setLayoutY(double y)
    {
        setY(y);
        System.out.println("root y before");
        this.root.setLayoutY(y);
        System.out.println("root y after");
    }
    public void setLayoutX(double x)
    {
        this.root.setLayoutX(x);
    }

    public double getLayoutY()
    {
        this.y = root.getLayoutY();
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

    public abstract boolean blast(Circle ball_c);

    public void increaseDifficulty(long difficulty)
    {
        rotateTransition.setDuration(Duration.millis(duration-difficulty));
    }
//    public boolean blast(Circle ball_c) {
//        return false;
//    }
}

