package sample;
/*
    Square obstacle
*/
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.w3c.dom.css.Rect;
//import java.time.Duration;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

class ObsRec
{
    Group root;
    public ObsRec()
    {
        this.root = new Group();
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return this.root;
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
    public boolean blast(Circle ball)
    {
        for(int i=0;i<root.getChildren().size();i++)
        {

            if (isCollide(ball, (Shape)root.getChildren().get(i)))
            {
                return true;
            }
        }
        return false;
    }

    public void show(long x, long y, long height)
    {
        ArrayList<Color> arr = new ArrayList<>();
        arr.add(Color.rgb(144, 13, 255));
        arr.add(Color.rgb (250, 225, 0));
        arr.add(Color.rgb(50, 219, 240));
        arr.add(Color.rgb(255, 1, 129));


//        int height=50+(int)(Math.random()*300);
        Rectangle r1 = new Rectangle(x, y, 50, height);
//        r1.setFill(arr.get(getRandom(4)));
        r1.setFill(Color.rgb(getRandom(256), getRandom(256), getRandom(256)));
//        Rectangle r2 = new Rectangle(x+200, 800-height, 50, 800 - height);
//        r2.setFill(arr.get(getRandom(4)));



        this.root = new Group();
        root.getChildren().addAll(r1);

//        this.y = y;

    }

    public int getRandom(int n)
    {
        Random rand = new Random();
        return rand.nextInt(n);
    }

}
