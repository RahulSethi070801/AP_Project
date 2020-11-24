// package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.Timeline;

import java.awt.*;

public class HorizontalLine extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        double X = -4000;
        Group figure = new Group();

        for(int i=0; i<100; i++) 
        {
            Group oneLine;
            oneLine = makeOneLine(X+=400);
            figure.getChildren().add(oneLine);
        }

        // Group root = new Group(line1, line2, line3, line4);


        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(figure, 800, 800));
        primaryStage.show();
    }

    public Group makeOneLine(double x)
    {
        Line line1 = new Line(x-200, 200, x-100, 200);
        line1.setStrokeWidth(10);
        Line line2 = new Line(x-100, 200, x, 200);
        line2.setStrokeWidth(10);
        Line line3 = new Line(x, 200, x+100, 200);
        line3.setStrokeWidth(10);
        Line line4 = new Line(x+100, 200, x+200, 200);
        line4.setStrokeWidth(10);

        line1.setStroke(Color.YELLOW);
        line2.setStroke(Color.GREEN);
        line3.setStroke(Color.CYAN);
        line4.setStroke(Color.BLUE);

        Group root = new Group(line1, line2, line3, line4);

        TranslateTransition translateTransition1 = new TranslateTransition();
        translateTransition1.setDuration(Duration.millis(5000));
        translateTransition1.setNode(line1);
        translateTransition1.setByX(2000);
        translateTransition1.setCycleCount(Timeline.INDEFINITE);
        translateTransition1.setAutoReverse(false);
        translateTransition1.setInterpolator(Interpolator.LINEAR);
        translateTransition1.play();

        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setDuration(Duration.millis(5000));
        translateTransition2.setNode(line2);
        translateTransition2.setByX(2000);
        translateTransition2.setCycleCount(Timeline.INDEFINITE);
        translateTransition2.setAutoReverse(false);
        translateTransition2.setInterpolator(Interpolator.LINEAR);
        translateTransition2.play();

        TranslateTransition translateTransition3 = new TranslateTransition();
        translateTransition3.setDuration(Duration.millis(5000));
        translateTransition3.setNode(line3);
        translateTransition3.setByX(2000);
        translateTransition3.setCycleCount(Timeline.INDEFINITE);
        translateTransition3.setAutoReverse(false);
        translateTransition3.setInterpolator(Interpolator.LINEAR);
        translateTransition3.play();

        TranslateTransition translateTransition4 = new TranslateTransition();
        translateTransition4.setDuration(Duration.millis(5000));
        translateTransition4.setNode(line4);
        translateTransition4.setByX(2000);
        translateTransition4.setCycleCount(Timeline.INDEFINITE);
        translateTransition4.setAutoReverse(false);
        translateTransition4.setInterpolator(Interpolator.LINEAR);
        translateTransition4.play();


        return root;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
