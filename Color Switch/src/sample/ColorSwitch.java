package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Random;

public class ColorSwitch implements Serializable {
    transient Group root;
    double y;
    String color;

    public ColorSwitch(){}

    public ColorSwitch(String color)
    {}
    public void setRoot(Group root)
    {
        this.root=root;
    }
    public Group getRoot()
    {
        return root;
    }
    public Group show(long y)
    {
        Arc arc1 = new Arc();
        arc1.setCenterX(700.0f);
        arc1.setCenterY(400.0f+y);
        arc1.setRadiusX(15.0f);
        arc1.setRadiusY(15.0f);
        arc1.setStartAngle(0.0f);
        arc1.setLength(90.0f);
        arc1.setFill(Color.rgb(144, 13, 255));

        Arc arc2 = new Arc();
        arc2.setCenterX(700.0f);
        arc2.setCenterY(400.0f+y);
        arc2.setRadiusX(15.0f);
        arc2.setRadiusY(15.0f);
        arc2.setStartAngle(90.0f);
        arc2.setLength(90.0f);
        arc2.setFill(Color.rgb (250, 225, 0));

        Arc arc3 = new Arc();
        arc3.setCenterX(700.0f);
        arc3.setCenterY(400.0f+y);
        arc3.setRadiusX(15.0f);
        arc3.setRadiusY(15.0f);
        arc3.setStartAngle(180.0f);
        arc3.setLength(90.0f);
        arc3.setFill(Color.rgb(50, 219, 240));

        Arc arc4 = new Arc();
        arc4.setCenterX(700.0f);
        arc4.setCenterY(400.0f+y);
        arc4.setRadiusX(15.0f);
        arc4.setRadiusY(15.0f);
        arc4.setStartAngle(270.0f);
        arc4.setLength(90.0f);
        arc4.setFill(Color.rgb(255, 1, 129));

        //Setting the type of the arc
        arc1.setType(ArcType.ROUND);
        arc2.setType(ArcType.ROUND);
        arc3.setType(ArcType.ROUND);
        arc4.setType(ArcType.ROUND);

        root = new Group(arc1, arc2, arc3, arc4);
        return root;
    }

    public void setLayoutY(double y)
    {
        this.y = y;
        root.setLayoutY(y);
    }
    public double getLayoutY()
    {
        return root.getLayoutY();
    }
}
