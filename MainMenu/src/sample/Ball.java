import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

public class Ball extends Application{
    
    @Override
    public void start(Stage stage) {
    	
    	Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
    	Circle ball = new Circle(10, Color.CADETBLUE);
        ball.relocate(50, 5);
        
        canvas.getChildren().add(ball);
        
        stage.setTitle("Animated Ball");
        stage.setScene(scene);
        stage.show();
        int flag=0;
        int i=0;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
                new EventHandler<ActionEvent>() {

        	    double dx = 7; //Step on x or velocity
        	    double dy = 3; //Step on y
                    
                @Override
                public void handle(ActionEvent t) {
                	//move the ball
                	// ball.setLayoutX(ball.getLayoutX() + dx);
                    // if (flag==0){
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        Bounds bounds = canvas.getBoundsInLocal();

                        //If the ball reaches the left or right border make the step negative
                        // if(ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) || 
                        //         ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) ){
                        
                        // 	dx = -dx;

                        // }

                        //If the ball reaches the bottom or top border make the step negative
                        if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) || 
                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){

                        	dy = -dy;

                        }
                    // }
                    // else if(flag==1 && i<1000){
                    //     ball.setLayoutY(ball.getLayoutY() + dy);

                    //     Bounds bounds = canvas.getBoundsInLocal();

                    //     //If the ball reaches the bottom or top border make the step negative
                    //     if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) || 
                    //             (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){

                    //     	dy = -dy;

                    //     }
                    //     i++;
                    // }
                    // else{
                    //     i=0;
                    //     flag=0;
                    // }
                }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("A key was pressed");
                // flag=1;
                // double dy = -30;
                // ball.setLayoutY(ball.getLayoutY() + dy);
                Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10), 
                    new EventHandler<ActionEvent>() {
        	        double dy = -5; //Step on y                    
                    @Override
                    public void handle(ActionEvent t) {
                            ball.setLayoutY(ball.getLayoutY() + dy);
                            Bounds bounds = canvas.getBoundsInLocal();
                            if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) || 
                                    (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){

                            	dy = -dy;
                            }
                    }
                }));
                timeline1.setCycleCount(15);
                timeline1.play();
                
            }
        });
    }
    
    public static void main(String[] args) {
        launch();
    }
}