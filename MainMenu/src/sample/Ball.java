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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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

    Ball(Bounds bounds) throws FileNotFoundException {
        show(bounds);
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

    public static boolean isCollide(Circle x, Group y)
    {
        Bounds RectA = x.localToScene(x.getBoundsInLocal());
        Bounds RectB = y.localToScene(y.getBoundsInLocal());

        return RectB.intersects(RectA);
    }

    public void show(Bounds bounds) throws FileNotFoundException
    {

        root = new Group();



        //stage.setScene(new Scene(root, 800, 800, Color.BLACK));
        Scene scene2 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
        Circle ball = new Circle(10, Color.rgb(144, 13, 255));
        ball.relocate(688, 700);

        Ring ring = new Ring();
        ring.show();
        Group root1 = ring.getRoot();

        root.getChildren().add(root1);
        root.getChildren().add(ball);


        String localDir = System.getProperty("user.dir");
        System.out.println(localDir);
        InputStream stream4 = new FileInputStream(localDir+"\\Star1.png");
        Image image4 = new Image(stream4);
        ImageView imageView4 = new ImageView();
        imageView4.setImage(image4);
        imageView4.setX(675);
        imageView4.setY(175);
        imageView4.setFitWidth(50);
        imageView4.setPreserveRatio(true);

        Group root5 = new Group(imageView4);
        root.getChildren().add(root5);


        int flag=0;
        int i=0;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(23),
                new EventHandler<ActionEvent>() {

                    double dx = 7; //Step on x or velocity
                    double dy = 7; //Step on y

                    @Override
                    public void handle(ActionEvent t) {

                        ball.setLayoutY(ball.getLayoutY() + dy);

                        if (root.getChildren().contains(root5) && isCollide(ball, root5))
                        {
                            System.out.println("touch");
                            while (true)
                            {
                                if (getRandom(4) == 0)
                                {
                                    continue;
                                }
                                if (getRandom(4) == 1)
                                {
                                    ball.setFill(Color.rgb (250, 225, 0));
                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 2)
                                {
                                    ball.setFill(Color.rgb(50, 219, 240));
                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 3)
                                {
                                    ball.setFill(Color.rgb(255, 1, 129));
                                    root.getChildren().remove(root5);
                                    break;
                                }
                            }
                        }



                        //Bounds bounds = root.getBoundsInParent();
//                        System.out.println(bounds);
//
//                        if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
//                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){
//                            System.out.println("Hello");
//                            dy = -dy;
//
//                        }

                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        scene2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("A key was pressed");
                timeline.play();
                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10),
                        new EventHandler<ActionEvent>() {
                            double dy = -7; //Step on y
                            @Override
                            public void handle(ActionEvent t) {
                                ball.setLayoutY(ball.getLayoutY() + dy);
                                Bounds bounds = root.getBoundsInLocal();

                                if (root.getChildren().contains(root5) && isCollide(ball, root5))
                                {
                                    System.out.println("touch");
                                    while (true)
                                    {
                                        if (getRandom(4) == 0)
                                        {
                                            continue;
                                        }
                                        if (getRandom(4) == 1)
                                        {
                                            ball.setFill(Color.rgb (250, 225, 0));
                                            root.getChildren().remove(root5);
                                            break;
                                        }
                                        if (getRandom(4) == 2)
                                        {
                                            ball.setFill(Color.rgb(50, 219, 240));
                                            root.getChildren().remove(root5);
                                            break;
                                        }
                                        if (getRandom(4) == 3)
                                        {
                                            ball.setFill(Color.rgb(255, 1, 129));
                                            root.getChildren().remove(root5);
                                            break;
                                        }
                                    }
                                }
//                                if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
//                                        (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){
//
//                                    dy = -dy;
//                                }
                            }
                        }));
                timeline1.setCycleCount(20);
                timeline1.play();

            }
        });

//        String localDir = System.getProperty("user.dir");

        InputStream stream1 = new FileInputStream(localDir+"\\Pause.png");
        Image image1 = new Image(stream1);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(1400);
        imageView1.setY(50);
        imageView1.setFitWidth(100);
        imageView1.setPreserveRatio(true);

        InputStream stream2 = new FileInputStream(localDir+"\\Star.jpg");
        Image image2 = new Image(stream2);
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        imageView2.setX(30);
        imageView2.setY(50);
        imageView2.setFitWidth(80);
        imageView2.setPreserveRatio(true);

        InputStream stream3 = new FileInputStream(localDir+"\\Star1.png");
        Image image3 = new Image(stream3);
        ImageView imageView3 = new ImageView();
        imageView3.setImage(image3);
        imageView3.setX(675);
        imageView3.setY(375);
        imageView3.setFitWidth(50);
        imageView3.setPreserveRatio(true);

        Text text1 = new Text();
        text1.setText("0");
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(5);
        text1.setX(130);
        text1.setY(100);

        Group root2 = new Group(imageView1);
        Group root3 = new Group(imageView2,imageView3);
        Group root4 = new Group(text1);
        root.getChildren().add(root2);
        root.getChildren().add(root3);
        root.getChildren().add(root4);



    }



}