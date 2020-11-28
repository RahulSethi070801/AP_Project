package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class MainPage
{

    Group root;
    ArrayList<Game> savedGames;
//    Stage stage;
    MainPage() throws FileNotFoundException
    {
        this.savedGames = new ArrayList<Game>();
        // TODO : read from a file (serializable)
        for(int i=0;i<5;i++){
            this.savedGames.add(new Game("Game"+(i+1)));
        }
//        this.stage=stage;
        show();
    }
    MainPage(Game game)
    {
        // TODO : first read all the saved games then save the recieved game
        this.savedGames = new ArrayList<Game>();
        // TODO : read from a file (serializable)
        for(int i=0;i<5;i++){
            this.savedGames.add(new Game("Game"+(i+1)));
        }
        this.savedGames.add(game);
        try {
            show();
        }
        catch(Exception e){
            System.out.println("asdas");
        }
    }

    public void setRoot(Group root)
    {
        this.root = root;
    }

    public Group getRoot()
    {
        return root;
    }

    public void printMenu(Game games[])
    {

    }

    public void printUserDetails(User user)
    {

    }

    public void show() throws FileNotFoundException
    {
        root = new Group();


        Main.stage.setScene(new Scene(root, 800, 800, Color.BLACK));
        Main.stage.setFullScreen(true);



        Heading hd = new Heading();
        hd.show();
        Group root1 = hd.getRoot();

        Design ds = new Design();
        ds.show();
        Group root2 = ds.getRoot();

        PlayButton pb = new PlayButton();
        pb.show();
        Group root3 = pb.getRoot();

        GameModesBanner gmb = new GameModesBanner(savedGames);
        gmb.show();
        Group root4 = gmb.getRoot();

        Exit exit = new Exit();
        exit.show();
        Group root5 = exit.getRoot();



        //Group root = new Group();
        root.getChildren().add(root1);
        root.getChildren().add(root2);
        root.getChildren().add(root3);
        root.getChildren().add(root4);
        root.getChildren().add(root5);
//        root.getChildren().add(root6);

    }



}
