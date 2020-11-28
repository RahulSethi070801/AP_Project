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
    Group root;
    Circle ball;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    Color color;

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
        //real_ball.setColor(Color.rgb(144, 13, 255));
        ball.relocate(688, 700);

        root.getChildren().add(this.ball);

        return ball;
//        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(23),
//                new EventHandler<ActionEvent>() {
//
//                    double dx = 7; //Step on x or velocity
//                    double dy = 7; //Step on y
//
//                    @Override
//                    public void handle(ActionEvent t) {
//
//                        ball.setLayoutY(ball.getLayoutY() + dy);
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
//        scene2.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.A) {
//                System.out.println("A key was pressed");
//                timeline.play();
//                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(13),
//                        new EventHandler<ActionEvent>() {
//                            double dy = -7; //Step on y
//                            @Override
//                            public void handle(ActionEvent t) {
//                                ball.setLayoutY(ball.getLayoutY() + dy);
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
//        InputStream stream1 = new FileInputStream(localDir+"\\Pause.png");
//        Image image1 = new Image(stream1);
//        ImageView imageView1 = new ImageView();
//        imageView1.setImage(image1);
//        imageView1.setX(1400);
//        imageView1.setY(50);
//        imageView1.setFitWidth(100);
//        imageView1.setPreserveRatio(true);
//
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
//        InputStream stream2 = new FileInputStream(localDir+"\\Star.jpg");
//        Image image2 = new Image(stream2);
//        ImageView imageView2 = new ImageView();
//        imageView2.setImage(image2);
//        imageView2.setX(30);
//        imageView2.setY(50);
//        imageView2.setFitWidth(80);
//        imageView2.setPreserveRatio(true);
//
//
//
//
//        Group root2 = new Group(imageView1);
//        Group root3 = new Group(imageView2);
//
//        root2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
//
//        root.getChildren().add(root2);
//        root.getChildren().add(root3);
//        root.getChildren().add(root4);
//        root.getChildren().add(root6);
//
        //return root;

    }


    public void setLayoutY(double y)
    {
        this.ball.setLayoutY(this.ball.getLayoutY()+y);
    }

    public void setFill(Color color)
    {
        this.ball.setFill(color);
    }

    public Bounds localToScene()
    {
        return this.ball.localToScene(this.ball.getBoundsInLocal());
    }
}