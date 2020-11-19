package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

public class Ball
{
    Group root;

    Ball(Bounds bounds)
    {
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

    public void show(Bounds bounds)
    {

        root = new Group();



        //stage.setScene(new Scene(root, 800, 800, Color.BLACK));
        Scene scene2 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
        Circle ball = new Circle(10, Color.CADETBLUE);
        ball.relocate(100, 500);

        Ring ring = new Ring();
        ring.show();
        Group root1 = ring.getRoot();

        root.getChildren().add(root1);
        root.getChildren().add(ball);

        //Main.stage.setTitle("Animated Ball");

        //Main.stage.show();
        int flag=0;
        int i=0;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {

                    double dx = 7; //Step on x or velocity
                    double dy = 3; //Step on y

                    @Override
                    public void handle(ActionEvent t) {

                        ball.setLayoutY(ball.getLayoutY() + dy);

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
        timeline.play();
        scene2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("A key was pressed");

                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10),
                        new EventHandler<ActionEvent>() {
                            double dy = -5; //Step on y
                            @Override
                            public void handle(ActionEvent t) {
                                ball.setLayoutY(ball.getLayoutY() + dy);
                                Bounds bounds = root.getBoundsInLocal();
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

    }



}