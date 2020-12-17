package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Help implements Display
{
    private Group root;

    Help() throws FileNotFoundException {
        show();
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public void show() throws FileNotFoundException {

        root = new Group();

        Scene scene4 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene4);
        Main.stage.setFullScreen(true);

        Text text1 = new Text();
        text1.setText("HELP");
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 70));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(5);
        text1.setX(700);
        text1.setY(100);

        Text text2 = new Text();
        text2.setText("Simply pressing the play button on the main screen \n" +
                "starts a game of Color Switch. This play mode allows you to \n" +
                "play through randomly generated obstacles until you fail, \n" +
                "collecting stars along the way.\n");

        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text2.setFill(Color.WHITE);
        text2.setStrokeWidth(3);
        text2.setX(100);
        text2.setY(200);

        String localDir = System.getProperty("user.dir");

        InputStream stream1 = new FileInputStream(localDir + "\\Back.jpg");
        javafx.scene.image.Image image1 = new Image(stream1);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(50);
        imageView1.setY(50);
        imageView1.setFitWidth(80);
        imageView1.setPreserveRatio(true);

        Group root2 = new Group(imageView1);
        root.getChildren().add(root2);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //Bounds bounds = root.getBoundsInParent();
                System.out.println("Hello World");
                //root2.setFill(Color.DARKSLATEBLUE);
                try {
                    new MainPage();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        root2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        root.getChildren().add(text1);
        root.getChildren().add(text2);
    }
}