package sample;

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
import java.util.*;
public class GameEngine {

    Group root;
    Scene scene2;
    ArrayList<Obstacle> obstacles;
    ArrayList<Star> stars;
    User user;
    GameEngine() throws FileNotFoundException {
        root = new Group();
        scene2 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
        new Game();
//        show();
        System.out.println("Game Engine Initialized");
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }


    public int getRandom(int n)
    {
        Random rand = new Random();
        return rand.nextInt(n);
    }

    public static boolean isCollide(Ball x, Group y)
    {
        Bounds RectA = x.localToScene();
        Bounds RectB = y.localToScene(y.getBoundsInLocal());

        return RectB.intersects(RectA);
    }

//    public void show() throws FileNotFoundException
//    {
//
//        Ball ball = new Ball();
//        ball.show();
//        Group root_ball = ball.getRoot();
//
//
//        // Obstacle 1 -> ring
//        Ring ring = new Ring();
//        ring.show();
//        Group root_ring = ring.getRoot();
//        root.getChildren().add(root_ring);
//
//
//        // Score count
//        Text text1 = new Text();
//        text1.setText("0");
//        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
//        text1.setFill(Color.WHITE);
//        text1.setStrokeWidth(5);
//        text1.setX(130);
//        text1.setY(100);
//        Group root_text = new Group(text1);
//        root.getChildren().add(root_text);
//
//        String localDir = System.getProperty("user.dir");
//        // collectable star
//        Star star = new Star();
//        Group root6 = star.show(675.0, 375.0);
//
//        ColorSwitch c1 = new ColorSwitch();
//        Group root5 = c1.show();
//        root.getChildren().add(root5);
//
//
//        int flag=0;
//        int i=0;
//
//        // timeline for ball
//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(23),
//                new EventHandler<ActionEvent>() {
//
//                    double dx = 7; //Step on x or velocity
//                    double dy = 7; //Step on y
//
//                    @Override
//                    public void handle(ActionEvent t) {
//
//                        ball.setLayoutY(dy);
//
//                        if (root.getChildren().contains(root5) && isCollide(ball, root5))
//                        {
//                            System.out.println("touch");
//                            while (true)
//                            {
//                                if (getRandom(4) == 0)
//                                {
//                                    continue;
//                                }
//                                if (getRandom(4) == 1)
//                                {
//                                    ball.setFill(Color.rgb (250, 225, 0));
//                                    root.getChildren().remove(root5);
//                                    break;
//                                }
//                                if (getRandom(4) == 2)
//                                {
//                                    ball.setFill(Color.rgb(50, 219, 240));
//                                    root.getChildren().remove(root5);
//                                    break;
//                                }
//                                if (getRandom(4) == 3)
//                                {
//                                    ball.setFill(Color.rgb(255, 1, 129));
//                                    root.getChildren().remove(root5);
//                                    break;
//                                }
//                            }
//                        }
//                        //Bounds bounds = root.getBoundsInParent();
////                        System.out.println(bounds);
////
////                        if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
////                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){
////                            System.out.println("Hello");
////                            dy = -dy;
////
////                        }
//                    }
//                }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//
//
//        // event handler for user control of ball
//        scene2.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.A) {
//                System.out.println("A key was pressed");
//                timeline.play();
//                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(13),
//                        new EventHandler<ActionEvent>() {
//                            double dy = -7; //Step on y
//                            @Override
//                            public void handle(ActionEvent t) {
//                                ball.setLayoutY( dy);
//                                Bounds bounds = root.getBoundsInLocal();
//
//                                if (root.getChildren().contains(root5) && isCollide(ball, root5))
//                                {
//                                    System.out.println("touch");
//                                    while (true)
//                                    {
//                                        if (getRandom(4) == 0)
//                                        {
//                                            continue;
//                                        }
//                                        if (getRandom(4) == 1)
//                                        {
//                                            ball.setFill(Color.rgb (250, 225, 0));
//                                            root.getChildren().remove(root5);
//                                            break;
//                                        }
//                                        if (getRandom(4) == 2)
//                                        {
//                                            ball.setFill(Color.rgb(50, 219, 240));
//                                            root.getChildren().remove(root5);
//                                            break;
//                                        }
//                                        if (getRandom(4) == 3)
//                                        {
//                                            ball.setFill(Color.rgb(255, 1, 129));
//                                            root.getChildren().remove(root5);
//                                            break;
//                                        }
//                                    }
//                                }
//                                if (root.getChildren().contains(root6) && isCollide(ball, root6))
//                                {
//                                    System.out.println("touch");
//                                    root.getChildren().remove(root6);
//                                    text1.setText("1");
//                                }
////                                if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
////                                        (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){
////
////                                    dy = -dy;
////                                } q
//                            }
//                        }));
//                timeline1.setCycleCount(20);
//                timeline1.play();
//
//            }
//        });
//
//
//
//        // Show Pause button
//        InputStream stream1 = new FileInputStream(localDir+"\\Pause.png");
//        Image image1 = new Image(stream1);
//        ImageView imageView1 = new ImageView();
//        imageView1.setImage(image1);
//        imageView1.setX(1400);
//        imageView1.setY(50);
//        imageView1.setFitWidth(100);
//        imageView1.setPreserveRatio(true);
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
////                Bounds bounds = root.getBoundsInParent();
//                System.out.println("Pause");
////                polygon.setFill(Color.DARKSLATEBLUE);
//                try {
//                    new PauseMenu();
//                } catch (FileNotFoundException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        };
//        //Registering the event filter
//
//
//        // Score Star
//        InputStream stream2 = new FileInputStream(localDir+"\\Star.jpg");
//        Image image2 = new Image(stream2);
//        ImageView imageView2 = new ImageView();
//        imageView2.setImage(image2);
//        imageView2.setX(30);
//        imageView2.setY(50);
//        imageView2.setFitWidth(80);
//        imageView2.setPreserveRatio(true);
//        Group root_score_star = new Group(imageView2);
//        root.getChildren().add(root_score_star);
//
//
//        Group root2 = new Group(imageView1);
//        root2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
//
//        root.getChildren().add(root2);
//
//
//        root.getChildren().add(root6);
//
//
//        root.getChildren().add(root_ball);
//
//    }



}