package sample;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group; 
import javafx.scene.shape.*; 
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;  
import javafx.util.Duration;  
import javafx.animation.RotateTransition;  
import javafx.animation.Interpolator;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

class PlayButton implements Display
{
    private Group root;

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public void show()
    {
        Arc arc1 = new Arc(750, 500, 100, 100, 0, 90);
        arc1.setFill(Color.rgb(144, 13, 255));
        arc1.setType(ArcType.ROUND);

        Arc arc2 = new Arc(750, 500, 100, 100, 90, 90);
        arc2.setFill(Color.rgb(250, 225, 0));
        arc2.setType(ArcType.ROUND);

        Arc arc3 = new Arc(750, 500, 100, 100, 180, 90);
        arc3.setFill(Color.rgb(50, 219, 240));
        arc3.setType(ArcType.ROUND);

        Arc arc4 = new Arc(750, 500, 100, 100, 270, 90);
        arc4.setFill(Color.rgb(255, 1, 129));
        arc4.setType(ArcType.ROUND);

        Arc arc5 = new Arc(750, 500, 80, 80, 0, 90);
        arc5.setFill(Color.rgb(144, 13, 255));
        arc5.setType(ArcType.ROUND);

        Arc arc6 = new Arc(750, 500, 80, 80, 90, 90);
        arc6.setFill(Color.rgb (250, 225, 0));
        arc6.setType(ArcType.ROUND);

        Arc arc7 = new Arc(750, 500, 80, 80, 180, 90);
        arc7.setFill(Color.rgb(50, 219, 240));
        arc7.setType(ArcType.ROUND);

        Arc arc8 = new Arc(750, 500, 80, 80, 270, 90);
        arc8.setFill(Color.rgb(255, 1, 129));
        arc8.setType(ArcType.ROUND);

        Arc arc9 = new Arc(750, 500, 60, 60, 0, 90);
        arc9.setFill(Color.rgb(144, 13, 255));
        arc9.setType(ArcType.ROUND);

        Arc arc10 = new Arc(750, 500, 60, 60, 90, 90);
        arc10.setFill(Color.rgb (250, 225, 0));
        arc10.setType(ArcType.ROUND);

        Arc arc11 = new Arc(750, 500, 60, 60, 180, 90);
        arc11.setFill(Color.rgb(50, 219, 240));
        arc11.setType(ArcType.ROUND);

        Arc arc12 = new Arc(750, 500, 60, 60, 270, 90);
        arc12.setFill(Color.rgb(255, 1, 129));
        arc12.setType(ArcType.ROUND);

        Circle circle = new Circle(750, 500, 90);
        circle.setFill(Color.rgb(0, 0, 0));

        Circle circle1 = new Circle(750, 500, 70);
        circle1.setFill(Color.rgb(0, 0, 0));

        Circle circle2 = new Circle(750, 500, 50);
        circle2.setFill(Color.rgb(39, 39, 39));
        circle2.setStrokeWidth(5.0f);
        circle2.setStroke(Color.BLACK);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            770.0, 500.0,
            730.0, 520.0,
            730.0, 480.0
        });
        polygon.setFill(Color.WHITE);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Bounds bounds = root.getBoundsInParent();
                System.out.println("Clicked on Play Button");
                polygon.setFill(Color.DARKSLATEBLUE);
                try {
                    new GameEngine();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        //Registering the event filter to play
        circle2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        polygon.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        root = new Group();

        Group root1 = new Group(arc1,arc4,arc3,arc2, circle);
        root.getChildren().add(root1);
        
        Group root2 = new Group( arc5,arc6,arc7,arc8, circle1);
        root.getChildren().add(root2);
        
        Group root3 = new Group( arc9,arc10,arc11,arc12, circle2);
        root.getChildren().add(root3);
        
        root.getChildren().add(polygon);

        RotateTransition rotate = new RotateTransition();  
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);  
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(2000));
        rotate.setAutoReverse(false);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(root1);
        rotate.play();  
        
        RotateTransition rotate1 = new RotateTransition();  
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(-360);  
        rotate1.setCycleCount(Timeline.INDEFINITE);
        rotate1.setDuration(Duration.millis(2000));  
        rotate1.setAutoReverse(false);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setNode(root2);
        rotate1.play();  
        
        RotateTransition rotate2 = new RotateTransition();  
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(360);  
        rotate2.setCycleCount(Timeline.INDEFINITE);
        rotate2.setDuration(Duration.millis(2000));  
        rotate2.setAutoReverse(false);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setNode(root3);
        rotate2.play();  

    }

}