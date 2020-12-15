package sample;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
public class SavedGames
{
    Group root;
    ArrayList<Game> savedGames;
    ArrayList<Game> games = new ArrayList<Game>();
    SavedGames(ArrayList<Game> savedGames) throws FileNotFoundException
    {
        this.savedGames = savedGames;
        root = new Group();
        File dir = new File("./");
        File[] directoryListing = dir.listFiles();
        ObjectInputStream in = null;
        Game  g;
        if (directoryListing != null) {
            for (File child : directoryListing) {
                // Do something with child
                String name[] = child.getName().split("\\.",0);
                try {
                    if (name[1].equals("txt")) {
//                    String localDir = System.getProperty("user.dir");
//                    System.out.println(localDir+"\\star.wav");
                    String localDir = System.getProperty("user.dir");
                    System.out.println(new ObjectInputStream(new FileInputStream((localDir+"\\"+name[0]+".txt"))));
                        in = new ObjectInputStream(new FileInputStream((localDir+"\\"+name[0]+".txt")));
                        this.games.add((Game)in.readObject());
                        System.out.println(games.get(games.size()-1).name);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        System.out.println(this.games.size()+" Games ");
        show();
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }
  
    public void show() throws FileNotFoundException {

        Scene scene3 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene3);
        Main.stage.setFullScreen(true);

        Polygon rectangle = new Polygon();
        rectangle.getPoints().addAll(new Double[]{
                850.0, 250.0,
                650.0, 250.0,
                650.0, 300.0,
                850.0, 300.0,
        });
        rectangle.setFill(Color.BLUE);
        root.getChildren().add(rectangle);

        Polygon t1 = new Polygon();
        t1.getPoints().addAll(new Double[]{
                850.0, 250.0,
                835.0, 275.0,
                850.0, 300.0,
        });
        t1.setFill(Color.rgb(0, 0, 0));
        root.getChildren().add(t1);

        Polygon t2 = new Polygon();
        t2.getPoints().addAll(new Double[]{
                650.0, 250.0,
                665.0, 275.0,
                650.0, 300.0,
        });
        t2.setFill(Color.rgb(0, 0, 0));
        root.getChildren().add(t2);

        Text t = new Text (700, 280, "Game Modes");
        // t.setText("This is a text sample");
        t.setFont(Font.font ("Comic Sans MS", 17));
        t.setFill(Color.WHITE);
        root.getChildren().add(t);

        for(int i=0;i<this.games.size();i++){
            rectangle = new Polygon();
            rectangle.getPoints().addAll(new Double[]{
                    850.0, 350.0+(i+1)*50,
                    650.0, 350.0+(i+1)*50,
                    650.0, 390.0+(i+1)*50,
                    850.0, 390.0+(i+1)*50,
            });
            rectangle.setFill(Color.WHITE);
            root.getChildren().add(rectangle);

            t = new Text (730, 380+(i+1)*50, this.games.get(i).name);
            // t.setText("This is a text sample");
            t.setFont(Font.font ("Comic Sans MS", 17));
            t.setFill(Color.BLUE);
            root.getChildren().add(t);
            int x = i+1;
            EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    Game game = games.get(x-1);
                    System.out.println(game.name);
                    System.out.println("Hello World"+x);
                    try {
                        System.out.println(game.obstacles.size());
                        System.out.println(game.stars.size());
                        System.out.println(game.score);
                        System.out.println(game.difficulty);
//                        System.out.println(game.colorSwitches.size());
                        game.newGame=false;
//                        game.setupGame();
                        System.out.println("HO gaya ");
                        new Game(game);
                        System.out.println("qowue");
                        game.show();
//                        game.play();
                    }
                    catch(Exception ex){
                        System.out.println("HEHEEH");
                        System.out.println(ex);
                    }
                }
            };
            //Registering the event filter 
            t.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            // t.setOnMouseEntered( e -> t.setFill(Color.YELLOW));
            registerHandler(t, Color.BLUE, Color.MAGENTA);
            
        }

        String localDir = System.getProperty("user.dir");

        InputStream stream1 = new FileInputStream(localDir + "//Back.jpg");
        Image image1 = new Image(stream1);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(50);
        imageView1.setY(50);
        imageView1.setFitWidth(80);
        imageView1.setPreserveRatio(true);

        Group root2 = new Group(imageView1);
        root.getChildren().add(root2);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //Bounds bounds = root.getBoundsInParent();
                System.out.println("Hello World");
                //root2.setFill(Color.DARKSLATEBLUE);
                try {
                    new MainPage();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        root2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void changeColor(Text t){
        t.setFill(Color.YELLOW);
    }

    private void registerHandler(Text s, Color defaultColor, Color hoverColor) {
        s.setOnMouseEntered( e -> s.setFill(hoverColor));
        s.setOnMouseExited(e -> s.setFill(defaultColor));
    }
}
