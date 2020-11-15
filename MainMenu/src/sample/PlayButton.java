import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

public class PlayButton extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Pane canvas = new Pane();
        
        Arc arc1 = new Arc();
        arc1.setCenterX(300.0f); 
        arc1.setCenterY(150.0f); 
        arc1.setStartAngle(0.0f); 
        arc1.setRadiusX(90.0f); 
        arc1.setLength(90.0f); 
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.rgb(144, 13, 255));
        arc1.setRadiusY(90.0f);  

        Arc arc2 = new Arc();
        arc2.setCenterX(300.0f); 
        arc2.setCenterY(150.0f); 
        arc2.setRadiusX(90.0f); 
        arc2.setRadiusY(90.0f); 
        arc2.setStartAngle(90.0f); 
        arc2.setLength(90.0f); 
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.rgb(250, 225, 0)); 
        
        Arc arc3 = new Arc();
        arc3.setCenterX(300.0f); 
        arc3.setCenterY(150.0f); 
        arc3.setRadiusX(90.0f); 
        arc3.setRadiusY(90.0f); 
        arc3.setStartAngle(180.0f); 
        arc3.setLength(90.0f); 
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.rgb(50, 219, 240));
        
        Arc arc4 = new Arc();
        arc4.setCenterX(300.0f); 
        arc4.setCenterY(150.0f); 
        arc4.setRadiusX(90.0f); 
        arc4.setRadiusY(90.0f); 
        arc4.setStartAngle(270.0f); 
        arc4.setLength(90.0f); 
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.rgb(255, 1, 129));
        
        Arc arc5 = new Arc();
        arc5.setCenterX(300.0f); 
        arc5.setCenterY(150.0f); 
        arc5.setRadiusX(70.0f); 
        arc5.setRadiusY(70.0f); 
        arc5.setStartAngle(0.0f); 
        arc5.setLength(90.0f); 
        arc5.setType(ArcType.ROUND);
        arc5.setFill(Color.rgb(144, 13, 255));
        
        Arc arc6 = new Arc();
        arc6.setCenterX(300.0f); 
        arc6.setCenterY(150.0f); 
        arc6.setRadiusX(70.0f); 
        arc6.setRadiusY(70.0f); 
        arc6.setStartAngle(90.0f); 
        arc6.setLength(90.0f); 
        arc6.setType(ArcType.ROUND);
        arc6.setFill(Color.rgb (250, 225, 0));
        
        Arc arc7 = new Arc();
        arc7.setCenterX(300.0f); 
        arc7.setCenterY(150.0f); 
        arc7.setRadiusX(70.0f); 
        arc7.setRadiusY(70.0f); 
        arc7.setStartAngle(180.0f); 
        arc7.setLength(90.0f); 
        arc7.setType(ArcType.ROUND);
        arc7.setFill(Color.rgb(50, 219, 240));
        
        Arc arc8 = new Arc();
        arc8.setCenterX(300.0f); 
        arc8.setCenterY(150.0f); 
        arc8.setRadiusX(70.0f); 
        arc8.setRadiusY(70.0f); 
        arc8.setStartAngle(270.0f); 
        arc8.setLength(90.0f); 
        arc8.setType(ArcType.ROUND);
        arc8.setFill(Color.rgb(255, 1, 129));
        
        Arc arc9 = new Arc();
        arc9.setCenterX(300.0f); 
        arc9.setCenterY(150.0f); 
        arc9.setRadiusX(50.0f); 
        arc9.setRadiusY(50.0f); 
        arc9.setStartAngle(0.0f); 
        arc9.setLength(90.0f); 
        arc9.setType(ArcType.ROUND);
        arc9.setFill(Color.rgb(144, 13, 255));
        
        Arc arc10 = new Arc();
        arc10.setCenterX(300.0f); 
        arc10.setCenterY(150.0f); 
        arc10.setRadiusX(50.0f); 
        arc10.setRadiusY(50.0f); 
        arc10.setStartAngle(90.0f); 
        arc10.setLength(90.0f); 
        arc10.setType(ArcType.ROUND);
        arc10.setFill(Color.rgb (250, 225, 0));
        
        Arc arc11 = new Arc();
        arc11.setCenterX(300.0f); 
        arc11.setCenterY(150.0f); 
        arc11.setRadiusX(50.0f); 
        arc11.setRadiusY(50.0f); 
        arc11.setStartAngle(180.0f); 
        arc11.setLength(90.0f); 
        arc11.setType(ArcType.ROUND);
        arc11.setFill(Color.rgb(50, 219, 240));
        
        Arc arc12 = new Arc();
        arc12.setCenterX(300.0f); 
        arc12.setCenterY(150.0f); 
        arc12.setRadiusX(50.0f); 
        arc12.setRadiusY(50.0f); 
        arc12.setStartAngle(270.0f); 
        arc12.setLength(90.0f); 
        arc12.setType(ArcType.ROUND);
        arc12.setFill(Color.rgb(255, 1, 129));
        
        Circle circle = new Circle();
        circle.setCenterX(300.0f); 
        circle.setCenterY(150.0f); 
        circle.setRadius(80.0f); 
        circle.setFill(Color.rgb(39, 39, 39));
        
        Circle circle1 = new Circle();
        circle1.setCenterX(300.0f); 
        circle1.setCenterY(150.0f); 
        circle1.setRadius(60.0f); 
        circle1.setFill(Color.rgb(39, 39, 39));      
        
        Circle circle2 = new Circle();
        circle2.setCenterX(300.0f); 
        circle2.setCenterY(150.0f); 
        circle2.setRadius(40.0f); 
        circle2.setFill(Color.rgb(39, 39, 39));     
        circle2.setStrokeWidth(5.0f);
        circle2.setStroke(Color.BLACK); 
       
        Polygon polygon = new Polygon();  
        polygon.getPoints().addAll(new Double[]{  
            320.0, 150.0,  
            280.0, 170.0,  
            280.0, 130.0 
        });
        polygon.setFill(Color.WHITE);

        Group root = new Group(arc1,arc4,arc3,arc2, circle);
        canvas.getChildren().add(root);
        
        Group root1 = new Group( arc5,arc6,arc7,arc8, circle1);
        canvas.getChildren().add(root1);
        
        Group root2 = new Group( arc9,arc10,arc11,arc12, circle2);
        canvas.getChildren().add(root2);
        
        canvas.getChildren().add(polygon);

        RotateTransition rotate = new RotateTransition();  
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);  
        rotate.setCycleCount(50);  
        rotate.setDuration(Duration.millis(2000));  
        rotate.setAutoReverse(false);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(root);  
        rotate.play();  
        
        RotateTransition rotate1 = new RotateTransition();  
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(-360);  
        rotate1.setCycleCount(50);  
        rotate1.setDuration(Duration.millis(2000));  
        rotate1.setAutoReverse(false);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setNode(root1);  
        rotate1.play();  
        
        RotateTransition rotate2 = new RotateTransition();  
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(360);  
        rotate2.setCycleCount(50);  
        rotate2.setDuration(Duration.millis(2000));  
        rotate2.setAutoReverse(false);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setNode(root2);  
        rotate2.play();  

        Scene scene = new Scene(canvas,600, 300, Color.rgb(39, 39, 39));

    
        stage.setTitle("Drawing a Circle"); 
        stage.setScene(scene); 
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}