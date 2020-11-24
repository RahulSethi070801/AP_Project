/*

2 concentric rings

*/

import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.shape.*; 
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;  
import javafx.util.Duration;  
import javafx.animation.RotateTransition;  
import javafx.animation.Interpolator;


public class ConcentricCircles extends Application{
    @Override     
    public void start(Stage stage) throws Exception {      
        Arc arc1 = new Arc();
        Arc arc2 = new Arc();
        Arc arc3 = new Arc();
        Arc arc4 = new Arc();
        Arc arc5 = new Arc();
        Arc arc6 = new Arc();
        Arc arc7 = new Arc();
        Arc arc8 = new Arc();
        Circle circle = new Circle();
        Circle circle1 = new Circle();
        
        arc1.setCenterX(300.0f); 
        arc2.setCenterX(300.0f); 
        arc3.setCenterX(300.0f); 
        arc4.setCenterX(300.0f); 
        arc5.setCenterX(300.0f); 
        arc6.setCenterX(300.0f); 
        arc7.setCenterX(300.0f); 
        arc8.setCenterX(300.0f); 
        circle.setCenterX(300.0f); 
        circle1.setCenterX(300.0f); 
        
        arc1.setCenterX(300.0f); 
        arc2.setCenterX(300.0f); 
        arc3.setCenterX(300.0f); 
        arc4.setCenterX(300.0f); 
        arc5.setCenterX(300.0f); 
        arc6.setCenterX(300.0f); 
        arc7.setCenterX(300.0f); 
        arc8.setCenterX(300.0f); 
        circle.setCenterX(300.0f); 
        circle1.setCenterX(300.0f); 
        
        arc1.setCenterY(150.0f); 
        arc2.setCenterY(150.0f); 
        arc3.setCenterY(150.0f); 
        arc4.setCenterY(150.0f); 
        arc5.setCenterY(150.0f); 
        arc6.setCenterY(150.0f); 
        arc7.setCenterY(150.0f); 
        arc8.setCenterY(150.0f); 
        circle.setCenterY(150.0f); 
        circle1.setCenterY(150.0f); 
        
        arc1.setRadiusX(90.0f); 
        arc2.setRadiusX(90.0f); 
        arc3.setRadiusX(90.0f); 
        arc4.setRadiusX(90.0f); 
        arc5.setRadiusX(70.0f); 
        arc6.setRadiusX(70.0f); 
        arc7.setRadiusX(70.0f); 
        arc8.setRadiusX(70.0f); 
        circle.setRadius(80.0f); 
        circle1.setRadius(60.0f); 
        
        arc1.setRadiusY(90.0f);  
        arc2.setRadiusY(90.0f); 
        arc3.setRadiusY(90.0f); 
        arc4.setRadiusY(90.0f); 
        arc5.setRadiusY(70.0f); 
        arc6.setRadiusY(70.0f); 
        arc7.setRadiusY(70.0f); 
        arc8.setRadiusY(70.0f); 
        
        arc1.setStartAngle(0.0f); 
        arc2.setStartAngle(90.0f); 
        arc3.setStartAngle(180.0f); 
        arc4.setStartAngle(270.0f); 
        arc5.setStartAngle(0.0f); 
        arc6.setStartAngle(90.0f); 
        arc7.setStartAngle(180.0f); 
        arc8.setStartAngle(270.0f); 
        
        arc1.setLength(90.0f); 
        arc2.setLength(90.0f); 
        arc3.setLength(90.0f); 
        arc4.setLength(90.0f); 
        arc5.setLength(90.0f); 
        arc6.setLength(90.0f); 
        arc7.setLength(90.0f); 
        arc8.setLength(90.0f); 
       
        arc1.setType(ArcType.ROUND);
        arc2.setType(ArcType.ROUND);
        arc3.setType(ArcType.ROUND);
        arc4.setType(ArcType.ROUND);
        arc5.setType(ArcType.ROUND);
        arc6.setType(ArcType.ROUND);
        arc7.setType(ArcType.ROUND);
        arc8.setType(ArcType.ROUND);
       
        arc1.setFill(Color.PURPLE);
        arc2.setFill(Color.YELLOW);
        arc3.setFill(Color.CYAN);
        arc4.setFill(Color.MAGENTA);
        arc5.setFill(Color.PURPLE);
        arc6.setFill(Color.YELLOW);
        arc7.setFill(Color.CYAN);
        arc8.setFill(Color.MAGENTA);
        circle.setFill(Color.WHITE);
        circle1.setFill(Color.WHITE);
        
        RotateTransition rotate = new RotateTransition();  
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);  
        rotate.setCycleCount(50);  
        rotate.setDuration(Duration.millis(2000));  
        rotate.setAutoReverse(false);
        rotate.setInterpolator(Interpolator.LINEAR);


        Group root = new Group(arc1,arc4,arc3,arc2, circle, arc5,arc6,arc7,arc8, circle1);
        Scene scene = new Scene(root ,600, 300);

        rotate.setNode(root);  
        rotate.play();  

        stage.setTitle("Drawing a Circle"); 
        stage.setScene(scene); 
        stage.show();
    }   
    // @FXML
    // private Arc arc;

    // @FXML
    // private void initialize() {
    //     Timeline animation = new Timeline(
    //         new KeyFrame(Duration.ZERO, new KeyValue(arc.startAngleProperty(), arc.getStartAngle(), Interpolator.LINEAR)),
    //         new KeyFrame(Duration.seconds(2), new KeyValue(arc.startAngleProperty(), arc.getStartAngle() - 360, Interpolator.LINEAR))
    //     );
    //     animation.setCycleCount(Animation.INDEFINITE);
    //     animation.play();
    // }

    public static void main(String args[]){ 
        launch(args); 
     } 
}
