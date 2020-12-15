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

class PlayButton
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

    public void show()
    {

        Arc arc1 = new Arc();
        arc1.setCenterX(750.0f);
        arc1.setCenterY(500.0f);
        arc1.setStartAngle(0.0f);
        arc1.setRadiusX(100.0f);
        arc1.setLength(90.0f);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.rgb(144, 13, 255));
        arc1.setRadiusY(100.0f);

        Arc arc2 = new Arc();
        arc2.setCenterX(750.0f);
        arc2.setCenterY(500.0f);
        arc2.setRadiusX(100.0f);
        arc2.setRadiusY(100.0f);
        arc2.setStartAngle(90.0f);
        arc2.setLength(90.0f);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.rgb(250, 225, 0));

        Arc arc3 = new Arc();
        arc3.setCenterX(750.0f);
        arc3.setCenterY(500.0f);
        arc3.setRadiusX(100.0f);
        arc3.setRadiusY(100.0f);
        arc3.setStartAngle(180.0f);
        arc3.setLength(90.0f);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.rgb(50, 219, 240));

        Arc arc4 = new Arc();
        arc4.setCenterX(750.0f);
        arc4.setCenterY(500.0f);
        arc4.setRadiusX(100.0f);
        arc4.setRadiusY(100.0f);
        arc4.setStartAngle(270.0f);
        arc4.setLength(90.0f);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.rgb(255, 1, 129));

        Arc arc5 = new Arc();
        arc5.setCenterX(750.0f);
        arc5.setCenterY(500.0f);
        arc5.setRadiusX(80.0f);
        arc5.setRadiusY(80.0f);
        arc5.setStartAngle(0.0f);
        arc5.setLength(90.0f);
        arc5.setType(ArcType.ROUND);
        arc5.setFill(Color.rgb(144, 13, 255));

        Arc arc6 = new Arc();
        arc6.setCenterX(750.0f);
        arc6.setCenterY(500.0f);
        arc6.setRadiusX(80.0f);
        arc6.setRadiusY(80.0f);
        arc6.setStartAngle(90.0f);
        arc6.setLength(90.0f);
        arc6.setType(ArcType.ROUND);
        arc6.setFill(Color.rgb (250, 225, 0));

        Arc arc7 = new Arc();
        arc7.setCenterX(750.0f);
        arc7.setCenterY(500.0f);
        arc7.setRadiusX(80.0f);
        arc7.setRadiusY(80.0f);
        arc7.setStartAngle(180.0f);
        arc7.setLength(90.0f);
        arc7.setType(ArcType.ROUND);
        arc7.setFill(Color.rgb(50, 219, 240));

        Arc arc8 = new Arc();
        arc8.setCenterX(750.0f);
        arc8.setCenterY(500.0f);
        arc8.setRadiusX(80.0f);
        arc8.setRadiusY(80.0f);
        arc8.setStartAngle(270.0f);
        arc8.setLength(90.0f);
        arc8.setType(ArcType.ROUND);
        arc8.setFill(Color.rgb(255, 1, 129));

        Arc arc9 = new Arc();
        arc9.setCenterX(750.0f);
        arc9.setCenterY(500.0f);
        arc9.setRadiusX(60.0f);
        arc9.setRadiusY(60.0f);
        arc9.setStartAngle(0.0f);
        arc9.setLength(90.0f);
        arc9.setType(ArcType.ROUND);
        arc9.setFill(Color.rgb(144, 13, 255));

        Arc arc10 = new Arc();
        arc10.setCenterX(750.0f);
        arc10.setCenterY(500.0f);
        arc10.setRadiusX(60.0f);
        arc10.setRadiusY(60.0f);
        arc10.setStartAngle(90.0f);
        arc10.setLength(90.0f);
        arc10.setType(ArcType.ROUND);
        arc10.setFill(Color.rgb (250, 225, 0));

        Arc arc11 = new Arc();
        arc11.setCenterX(750.0f);
        arc11.setCenterY(500.0f);
        arc11.setRadiusX(60.0f);
        arc11.setRadiusY(60.0f);
        arc11.setStartAngle(180.0f);
        arc11.setLength(90.0f);
        arc11.setType(ArcType.ROUND);
        arc11.setFill(Color.rgb(50, 219, 240));

        Arc arc12 = new Arc();
        arc12.setCenterX(750.0f);
        arc12.setCenterY(500.0f);
        arc12.setRadiusX(60.0f);
        arc12.setRadiusY(60.0f);
        arc12.setStartAngle(270.0f);
        arc12.setLength(90.0f);
        arc12.setType(ArcType.ROUND);
        arc12.setFill(Color.rgb(255, 1, 129));

        Circle circle = new Circle();
        circle.setCenterX(750.0f);
        circle.setCenterY(500.0f);
        circle.setRadius(90.0f);
        circle.setFill(Color.rgb(0, 0, 0));

        Circle circle1 = new Circle();
        circle1.setCenterX(750.0f);
        circle1.setCenterY(500.0f);
        circle1.setRadius(70.0f);
        circle1.setFill(Color.rgb(0, 0, 0));

        Circle circle2 = new Circle();
        circle2.setCenterX(750.0f);
        circle2.setCenterY(500.0f);
        circle2.setRadius(50.0f);
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