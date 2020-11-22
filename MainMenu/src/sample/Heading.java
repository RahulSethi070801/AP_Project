package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Heading
{
    Group root;

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }


    public void show() throws FileNotFoundException
    {
        root = new Group();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //stage.setTitle("Hello World");

        Text text1 = new Text();
        text1.setText("C");
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(5);
        text1.setX(550);
        text1.setY(150);

        Text text2 = new Text();
        text2.setText("L");
        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        text2.setFill(Color.WHITE);
        text2.setStrokeWidth(5);
        text2.setX(710);
        text2.setY(150);

        Text text3 = new Text();
        text3.setText("R");
        text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        text3.setFill(Color.WHITE);
        text3.setStrokeWidth(5);
        text3.setX(855);
        text3.setY(150);

        Text text4 = new Text();
        text4.setText("SWITCH");
        text4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
        text4.setFill(Color.WHITE);
        text4.setStrokeWidth(5);
        text4.setX(550);
        text4.setY(300);


        Arc arc1 = new Arc();
        arc1.setCenterX(660.0f);
        arc1.setCenterY(125.0f);
        arc1.setRadiusX(40.0f);
        arc1.setRadiusY(40.0f);
        arc1.setStartAngle(0.0f);
        arc1.setLength(90.0f);
        arc1.setFill(Color.rgb(144, 13, 255));
        arc1.setType(ArcType.ROUND);

        Arc arc2 = new Arc();
        arc2.setCenterX(660.0f);
        arc2.setCenterY(125.0f);
        arc2.setRadiusX(40.0f);
        arc2.setRadiusY(40.0f);
        arc2.setStartAngle(90.0f);
        arc2.setLength(90.0f);
        arc2.setFill(Color.rgb (250, 225, 0));
        arc2.setType(ArcType.ROUND);

        Arc arc3 = new Arc();
        arc3.setCenterX(660.0f);
        arc3.setCenterY(125.0f);
        arc3.setRadiusX(40.0f);
        arc3.setRadiusY(40.0f);
        arc3.setStartAngle(180.0f);
        arc3.setLength(90.0f);
        arc3.setFill(Color.rgb(50, 219, 240));
        arc3.setType(ArcType.ROUND);

        Arc arc4 = new Arc();
        arc4.setCenterX(660.0f);
        arc4.setCenterY(125.0f);
        arc4.setRadiusX(40.0f);
        arc4.setRadiusY(40.0f);
        arc4.setStartAngle(270.0f);
        arc4.setLength(90.0f);
        arc4.setFill(Color.rgb(255, 1, 129));
        arc4.setType(ArcType.ROUND);

        Circle circle1 = new Circle(660, 125, 30);
        circle1.setFill(Color.BLACK);

        Group root1 = new Group(arc1, arc2, arc3, arc4, circle1);

        RotateTransition rotateTransition1 = new RotateTransition();
        rotateTransition1.setDuration(Duration.millis(1000));
        rotateTransition1.setNode(root1);
        rotateTransition1.setByAngle(360);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setInterpolator(Interpolator.LINEAR);
        rotateTransition1.play();


        Arc arc5 = new Arc();
        arc5.setCenterX(810.0f);
        arc5.setCenterY(125.0f);
        arc5.setRadiusX(40.0f);
        arc5.setRadiusY(40.0f);
        arc5.setStartAngle(0.0f);
        arc5.setLength(90.0f);
        arc5.setFill(Color.rgb(144, 13, 255));
        arc5.setType(ArcType.ROUND);

        Arc arc6 = new Arc();
        arc6.setCenterX(810.0f);
        arc6.setCenterY(125.0f);
        arc6.setRadiusX(40.0f);
        arc6.setRadiusY(40.0f);
        arc6.setStartAngle(90.0f);
        arc6.setLength(90.0f);
        arc6.setFill(Color.rgb (250, 225, 0));
        arc6.setType(ArcType.ROUND);

        Arc arc7 = new Arc();
        arc7.setCenterX(810.0f);
        arc7.setCenterY(125.0f);
        arc7.setRadiusX(40.0f);
        arc7.setRadiusY(40.0f);
        arc7.setStartAngle(180.0f);
        arc7.setLength(90.0f);
        arc7.setFill(Color.rgb(50, 219, 240));
        arc7.setType(ArcType.ROUND);

        Arc arc8 = new Arc();
        arc8.setCenterX(810.0f);
        arc8.setCenterY(125.0f);
        arc8.setRadiusX(40.0f);
        arc8.setRadiusY(40.0f);
        arc8.setStartAngle(270.0f);
        arc8.setLength(90.0f);
        arc8.setFill(Color.rgb(255, 1, 129));
        arc8.setType(ArcType.ROUND);

        Circle circle2 = new Circle(810, 125, 30);
        circle1.setFill(Color.BLACK);

        Group root2 = new Group(arc5, arc6, arc7, arc8, circle2);

        RotateTransition rotateTransition2 = new RotateTransition();
        rotateTransition2.setDuration(Duration.millis(1000));
        rotateTransition2.setNode(root2);
        rotateTransition2.setByAngle(360);
        rotateTransition2.setCycleCount(Timeline.INDEFINITE);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.setInterpolator(Interpolator.LINEAR);
        rotateTransition2.play();

        Group root3 = new Group(text1, text2,text3, text4);

        String localDir = System.getProperty("user.dir");

        InputStream stream1 = new FileInputStream(localDir+"\\QuestionMark.png");
        Image image1 = new Image(stream1);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(400);
        imageView1.setY(400);
        imageView1.setFitWidth(80);
        imageView1.setPreserveRatio(true);

        InputStream stream2 = new FileInputStream(localDir+"\\Achievements.png");
        Image image2 = new Image(stream2);
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        imageView2.setX(400);
        imageView2.setY(500);
        imageView2.setFitWidth(80);
        imageView2.setPreserveRatio(true);



        InputStream stream3 = new FileInputStream(localDir + "\\Speaker.png");
        Image image3 = new Image(stream3);
        ImageView imageView3 = new ImageView();
        imageView3.setImage(image3);
        imageView3.setX(1020);
        imageView3.setY(400);
        imageView3.setFitWidth(80);
        imageView3.setPreserveRatio(true);

        InputStream stream4 = new FileInputStream(localDir +"\\Music.png");
        Image image4 = new Image(stream4);
        ImageView imageView4 = new ImageView();
        imageView4.setImage(image4);
        imageView4.setX(1007);
        imageView4.setY(500);
        imageView4.setFitWidth(110);
        imageView4.setPreserveRatio(true);


        Group root4 = new Group(imageView1, imageView2, imageView3, imageView4);


//        PlayButton pb = new PlayButton();
//        pb.show();
//        Group root5 = pb.getRoot();
//
//        GameModesBanner gmb = new GameModesBanner();
//        gmb.show();
//        Group root6 = gmb.getRoot();



        //Group root = new Group();
        root.getChildren().add(root1);
        root.getChildren().add(root2);
        root.getChildren().add(root3);
        root.getChildren().add(root4);
//        root.getChildren().add(root5);
//        root.getChildren().add(root6);

    }

}
