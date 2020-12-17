package sample;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group; 
import javafx.scene.shape.*; 
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.StageStyle;
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

public class SavedGames implements Display
{
    private Group root;
    private ArrayList<Game> savedGames;
    private ArrayList<Game> games = new ArrayList<Game>();

    SavedGames() throws FileNotFoundException
    {
        this.root = new Group();
        this.savedGames = new ArrayList<Game>();
        
        File dir = new File("./");
        File[] directoryListing = dir.listFiles();
        ObjectInputStream in = null;
        String localDir = System.getProperty("user.dir");

        if (directoryListing != null) {
            for (File child : directoryListing) { // iterator design pattern
                String name[] = child.getName().split("\\.",0);
                try {
                    if (name.length>1 && name[1].equals("txt")) {
                        in = new ObjectInputStream(new FileInputStream((localDir+"\\"+name[0]+".txt")));
                        this.games.add((Game)in.readObject());
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
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

        VBox pauseRoot = new VBox(40);
        pauseRoot.setFillWidth(true);
        pauseRoot.setId("menu");
        pauseRoot.setAlignment(Pos.CENTER);
        pauseRoot.setPadding(new Insets(20));
        pauseRoot.setEffect(new DropShadow(20, Color.BLACK));
        //adding styled sheet to VBox
        String  style= getClass().getResource("styles.css").toExternalForm();
        pauseRoot.getStylesheets().add(style);


        //adding label
        Label label = new Label("Saved Games");
        label.setId("paused");
        label.setEffect(new DropShadow(20,Color.BLACK));
        pauseRoot.getChildren().add(label);

        Stage popupStage = new Stage(StageStyle.TRANSPARENT);
        popupStage.initOwner(Main.stage);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
        popupStage.setX(500);
        popupStage.setY(250);

        for(int i=0;i<this.games.size();i++){
            Button restart = new Button(this.games.get(i).getName());
            restart.setId("resume");
            restart.setEffect(new DropShadow(20, Color.BLACK));
            pauseRoot.getChildren().add(restart);

            int x = i+1;
            restart.setOnAction(event -> {
                Game game = games.get(x-1);
                System.out.println(game.getName());
                try {
                    game.setNewGameFalse();
                    new Game(game);
                    System.out.println("Saved Game is initialized");
                    game.show();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                popupStage.hide();
            });
        }

        Button exit=new Button("Exit");
        exit.setId("exit");
        exit.setEffect(new DropShadow(20, Color.BLACK));
        pauseRoot.getChildren().add(exit);

        exit.setOnAction(event -> {
            root.setEffect(null);
            popupStage.hide();
            try {
                new MainPage();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        popupStage.show();
    }

    public void changeColor(Text t){
        t.setFill(Color.YELLOW);
    }

    private void registerHandler(Text s, Color defaultColor, Color hoverColor) {
        s.setOnMouseEntered( e -> s.setFill(hoverColor));
        s.setOnMouseExited(e -> s.setFill(defaultColor));
    }
}
