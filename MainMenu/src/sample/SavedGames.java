package sample;

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
import javafx.scene.text.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SavedGames
{

    SavedGames()
    {
        show();
    }
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
        root = new Group();

        Scene scene3 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene3);
        Main.stage.setFullScreen(true);

        Polygon rectangle = new Polygon();
        rectangle.getPoints().addAll(new Double[]{
                900.0, 250.0,
                700.0, 250.0,
                700.0, 300.0,
                900.0, 300.0,
        });
        rectangle.setFill(Color.BLUE);
        root.getChildren().add(rectangle);

        Polygon t1 = new Polygon();
        t1.getPoints().addAll(new Double[]{
                900.0, 250.0,
                885.0, 275.0,
                900.0, 300.0,
        });
        t1.setFill(Color.rgb(0, 0, 0));
        root.getChildren().add(t1);

        Polygon t2 = new Polygon();
        t2.getPoints().addAll(new Double[]{
                700.0, 250.0,
                715.0, 275.0,
                700.0, 300.0,
        });
        t2.setFill(Color.rgb(0, 0, 0));
        root.getChildren().add(t2);

        Text t = new Text (750, 280, "Game Modes");
        // t.setText("This is a text sample");
        t.setFont(Font.font ("Comic Sans MS", 17));
        t.setFill(Color.WHITE);
        root.getChildren().add(t);

        for(int i=1;i<5;i++){
            Polygon rectangle1 = new Polygon();
            rectangle1.getPoints().addAll(new Double[]{
                    900.0, 360.0+i*3,
                    700.0, 363.0+i*3,
                    700.0, 380.0+i*3,
                    900.0, 380.0+i*3,
            });
            rectangle1.setFill(Color.WHITE);
            root.getChildren().add(rectangle1);

            t = new Text (750, 380+i*30, "Game "+i);
            // t.setText("This is a text sample");
            t.setFont(Font.font ("Comic Sans MS", 17));
            t.setFill(Color.BLUE);
            root.getChildren().add(t);
            int x = i;
            EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    System.out.println("Hello World"+x);
                }
            };
            //Registering the event filter 
            t.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            // t.setOnMouseEntered( e -> t.setFill(Color.YELLOW));
            registerHandler(t, Color.BLUE, Color.MAGENTA);
            
        }

        //Scene scene = new Scene(root, Color.rgb(39, 39, 39));

//        stage.setTitle("Drawing a Circle");
////        stage.setScene(scene);
////        stage.setFullScreen(true);
////        stage.show();
    }

    public void changeColor(Text t){
        t.setFill(Color.YELLOW);
    }
    private void registerHandler(Text s, Color defaultColor, Color hoverColor) {
        s.setOnMouseEntered( e -> s.setFill(hoverColor));
        s.setOnMouseExited(e -> s.setFill(defaultColor));
    }
}
