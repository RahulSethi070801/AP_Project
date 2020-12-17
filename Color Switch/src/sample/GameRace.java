package sample;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.beans.Transient;
import java.io.*;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Random;



public class GameRace implements Display
{
    public static Stage stage;
    // serializable objects
    transient Group root;
    transient Scene scene2;
    transient ArrayList<Group> root_list = new ArrayList<Group>();
    transient Ball ball;
    transient AnimationTimer t;
    transient Text text1;

    ArrayList<ObsRec> obstacles;
    ArrayList<StarRace> stars;
    double g = 1500;
    double speed = 0.0;

    long score = 0;
    long difficulty = 0;
    long x=600;
    String name;
    boolean newGame = true;
    transient int ind = 0;
    long count = 0;

    Random rand = new Random();


    public long getDifficulty()
    {
        return this.difficulty;
    }
    public void setDifficulty(){}
    public void playGame(){}
    public void setBackground(){}


    public void setStars(int stars){}
    public double getStars(){
        return this.score;
    }

    public GameRace()
    {
        root= new Group();
        scene2 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
        this.obstacles = new ArrayList<>();
        try{
            show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

//    public void init()
//    {
//        root= new Group();
//        scene2=new Scene(root, 800, 800);
//        scene2.setFill(Color.BLACK);
//        Main.stage2.setScene(scene2);
//        Main.stage2.setFullScreen(true);
//        this.obstacles = new ArrayList<>();
//        try{
//            show();
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//    }



    public void addObstacle() throws FileNotFoundException
    {
        x+=200;

        long height=300+(int)(Math.random()*400);
        if (count%2==0)
        {
            ObsRec r = new ObsRec();
            r.show(x,0, height);
            obstacles.add(r);
            Group root_rec = r.getRoot();
            root.getChildren().add(root_rec);
            root_list.add(root_rec);

            StarRace star = new StarRace();
            star.show(x, height+50);
            stars.add(star);
            root.getChildren().add(star.getRoot());
            root_list.add(star.getRoot());
        }
        else
        {

            ObsRec r = new ObsRec();
            r.show(x,1000-height, height);
            obstacles.add(r);
            Group root_rec = r.getRoot();
            root.getChildren().add(root_rec);
            root_list.add(root_rec);

            StarRace star = new StarRace();
            star.show(x, 1000-height-100);
            stars.add(star);
            root.getChildren().add(star.getRoot());
            root_list.add(star.getRoot());
        }
        count++;
    }



    public int getRandom(int n)
    {
        Random rand = new Random();
        return rand.nextInt(n);
    }


    public void update(double time, Circle ball_c) throws FileNotFoundException
    {

        time/=Math.pow(10,9);
        this.speed += this.g*time;
        double s = (this.speed*time + 0.5*this.g*Math.pow(time,2));
//        System.out.println(this.ball.getLayY()+" "+s);
        if(this.ball.getLayY()+s>900)
        {
            explode(ball);
            return;
        }
        this.ball.setLayoutY(s);

        int index= 0 ;
        while (index<stars.size())
        {
            if (stars.get(index).blast(ball_c))
            {
                text1.setText(String.valueOf(++score));
                root.getChildren().remove(stars.get(index).getRoot());
                root_list.remove(stars.get(index).getRoot());
                stars.remove(index);
                ball.setFill(Color.rgb(getRandom(256), getRandom(256), getRandom(256)));
                continue;
            }
            index++;
        }

//        ArrayList<Double> a = new ArrayList<>();
//        int index=0;
//        while(index<stars.size()){
//
//            if (isCollide(ball_c, stars.get(index).getRoot()))
//            {
////                System.out.println("collide");
////                root.getChildren().remove(stars.get(i).getRoot());
////                //root_list.remove(stars.get(0).getRoot());
////                stars.remove(i);
//                text1.setText(String.valueOf(++score));
//                    System.out.println(index);
//                    stars.remove(index);
//                    continue;
//                // Sound
////                String localDir = System.getProperty("user.dir");
////                String path = localDir+"\\star.wav";
////                Media media = new Media(new File(path).toURI().toString());
////                MediaPlayer mediaPlayer = new MediaPlayer(media);
////                mediaPlayer.setAutoPlay(true);
//            }
//            index++;
//        }
//        stars.removeAll(a);

        for (int i=0; i<obstacles.size(); i++)
        {
//            System.out.println(this.obstacles.get(i)+" obstacle "+this.obstacles.get(i).getLayoutY());
            if (obstacles.get(i).blast(ball_c))
            {
//                String localDir = System.getProperty("user.dir");
//                String path = localDir+"\\dead.wav";
//                Media media = new Media(new File(path).toURI().toString());
//                MediaPlayer mediaPlayer = new MediaPlayer(media);
//                mediaPlayer.setAutoPlay(true);
//                this.ind = i;

//                System.exit(0);

                explode(ball);
            }
        }
    }

    public void explode(Ball ball)
    {
        ParallelTransition parallelTransition = new ParallelTransition();

        ArrayList<Color> arr = new ArrayList<>();
        arr.add(Color.rgb(144, 13, 255));
        arr.add(Color.rgb (250, 225, 0));
        arr.add(Color.rgb(50, 219, 240));
        arr.add(Color.rgb(255, 1, 129));
        Group root3 = new Group();

        for (int i=0; i<1000; i++)
        {
            Path path = new Path();
            //Arc a1 = new Arc(250, 250, 3,3,0,360);
            Circle c1 = new Circle(688, ball.getLayY(),3);
            c1.setFill(arr.get(getRandom(4)));
            root3.getChildren().add(c1);

            MoveTo moveTo = new MoveTo(688, ball.getLayY());
            LineTo lineTo;
            if (i%2==0)
            {
                int x1 = 0;
                int x2 = 700;
                lineTo = new LineTo(getRandom(x2)-x1 - 1400, getRandom((int)ball.getLayY()+ 1000));
            }
            else
            {
                int x1 = 700;
                //int x2 = 1400;
                lineTo = new LineTo(getRandom(x1)+x1 + 1000, getRandom((int)ball.getLayY()+ 1000));
            }

            path.getElements().addAll(moveTo, lineTo);

            PathTransition pt = new PathTransition();
            pt.setDuration(Duration.millis(400 + getRandom(1000)));
            pt.setNode(c1);
            pt.setPath(path);
            parallelTransition.getChildren().add(pt);
        }
        root.getChildren().add(root3);
        SequentialTransition sq = new SequentialTransition(parallelTransition);
        sq.play();
        ball.setFill(Color.TRANSPARENT);
        //root.getChildren().remove(root3);
        t.stop();
        sq.setOnFinished(actionEvent -> revive());
    }

    public void revive()
    {
        if(score>=0) {
            //System.out.println("starting");
            t.stop();
            root.setEffect(new GaussianBlur());
            VBox pauseRoot = new VBox(40);
            pauseRoot.setFillWidth(true);
            String  style= getClass().getResource("styles.css").toExternalForm();
            pauseRoot.getStylesheets().add(style);
            Label label = new Label("Game Over");
            label.setId("paused");
            label.setEffect(new DropShadow(20,Color.BLACK));
            pauseRoot.setId("menu");
            pauseRoot.getChildren().add(label);
            pauseRoot.setAlignment(Pos.CENTER);
            pauseRoot.setPadding(new Insets(20));

            Label label1 = new Label("Score : " + score);
            label1.setId("paused");
            label1.setEffect(new DropShadow(20,Color.BLACK));
            pauseRoot.getChildren().add(label1);

            Button restart = new Button("Restart ");
            Button exit=new Button("Exit");

            restart.setId("save");
            exit.setId("exit");

            exit.setEffect(new DropShadow(20, Color.BLACK));
            pauseRoot.getChildren().add(restart);
            pauseRoot.getChildren().add(exit);
            pauseRoot.setEffect(new DropShadow(20, Color.BLACK));

            Stage popupStage = new Stage(StageStyle.TRANSPARENT);
            popupStage.initOwner(Main.stage);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));

            popupStage.setX(500);
            popupStage.setY(250);

            restart.setOnAction(event -> {
                root.setEffect(null);
                try {
                    //System.out.println("restart");
                    popupStage.hide();
                    new GameRace();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                popupStage.hide();

            });
            exit.setOnAction(event -> {
                root.setEffect(null);
                popupStage.hide();

                try {
                    //Main.stage2.close();
                    new MainPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            popupStage.show();
        }
        else {
            root.setEffect(null);
            t.stop();
            try {
                //Main.stage2.close();
                new MainPage();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //System.out.println("qwebo");
        }
    }





    public void tapBall()
    {
        System.out.println("Tap ball");
        // inverting direction
        this.speed = -400;
        // playing sound
        String localDir = System.getProperty("user.dir");
        String path = localDir+"\\jump.wav";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    public void scroll()
    {
//        if(ball.getLayY()<375) {
//        System.out.println("scroll");
        for (int i = 0; i < root_list.size(); i++) {
            double dex = root_list.get(i).getLayoutX();
//                System.out.println(dey + " dey");
            root_list.get(i).setLayoutX(dex - 2);
        }
//        }
    }

    int counter=0;
    public void show() throws FileNotFoundException, IOException, ClassNotFoundException
    {

        ball = new Ball(); // ball is the object of Ball Class
        Circle ball_c = ball.show();
        Group root_ball = ball.getRoot();
        root.getChildren().add(root_ball);
        stars = new ArrayList<StarRace>();

        for (int i = 0; i < 25; i++) {
            addObstacle();
        }

        // Score count
        text1 = new Text();
        text1.setText(String.valueOf(score));
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(5);
        text1.setX(130);
        text1.setY(100);
        Group root_text = new Group(text1);
        root.getChildren().add(root_text);

        String localDir = System.getProperty("user.dir");

//        System.out.println("pqwinep");
        t = new AnimationTimer(){
            long lastUpdate;
            int i;
            @Override
            public void start(){
                lastUpdate = System.nanoTime();
                super.start();
            }
            @Override
            public void handle(long now){
//                System.out.println(now);
                //Ball Update
                long elapsed = now - lastUpdate;
                try {
//                    System.out.println("aosdo");
                    update(elapsed, ball_c);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                scroll();

                lastUpdate = now;
            }
        };

//        System.out.println("hahaahah");
//        int counter = 0;
        scene2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.Q) {
//                final int ctr=counter;
//                System.out.println("UP"+ctr);
//                counter++;
//                System.out.println(scene2);
                tapBall();
                t.start();
            }
        });

//        System.out.println("before start");

//        System.out.println("after start");
        // Show Pause button
        InputStream stream1 = new FileInputStream(localDir+"\\Pause.png");
        Image image1 = new Image(stream1);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(1400);
        imageView1.setY(50);
        imageView1.setFitWidth(100);
        imageView1.setPreserveRatio(true);
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
////                Bounds bounds = root.getBoundsInParent();
//                //System.out.println("Pause");
////                polygon.setFill(Color.DARKSLATEBLUE);
//                try {
////                    t.pause();
////                    timeline1.pause();
//                    new PauseMenu();
//                } catch (FileNotFoundException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        };

        // pause menu
        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e)
            {
//                t.pause();
//                timeline1.pause();
                t.stop();
                root.setEffect(new GaussianBlur());

                VBox pauseRoot = new VBox(40);
                String  style= getClass().getResource("styles.css").toExternalForm();
                pauseRoot.getStylesheets().add(style);
                pauseRoot.setFillWidth(true);
                Label paused = new Label("Paused");
                paused.setEffect(new DropShadow(20,Color.BLACK));
                paused.setId("paused");
                pauseRoot.getChildren().add(paused);
                pauseRoot.setId("menu");
                pauseRoot.setAlignment(Pos.CENTER);
                pauseRoot.setPadding(new Insets(20));
                pauseRoot.setEffect(new DropShadow(20, Color.BLACK));
                Button resume = new Button("Resume");
                Button exit=new Button("Exit");
                Button restart = new Button("Restart ");
                resume.setId("resume");
                restart.setId("resume");
                exit.setId("exit");
                exit.setEffect(new DropShadow(20, Color.BLACK));
                restart.setEffect(new DropShadow(20, Color.BLACK));
                resume.setEffect(new DropShadow(20, Color.BLACK));

                pauseRoot.getChildren().add(resume);
                pauseRoot.getChildren().add(restart);
                pauseRoot.getChildren().add(exit);

                Stage popupStage = new Stage(StageStyle.TRANSPARENT);
                popupStage.initOwner(Main.stage);
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
                popupStage.setX(500);
                popupStage.setY(250);

                resume.setOnAction(event -> {
                    root.setEffect(null);
                    t.start();
                    popupStage.hide();
                });

                exit.setOnAction(event -> {
                    root.setEffect(null);
                    popupStage.hide();
                    try {
                        //Main.stage2.close();
                        new MainPage();
                    } catch (FileNotFoundException | InterruptedException e1) {
                        e1.printStackTrace();
                    }
                });
                restart.setOnAction(event -> {
                    root.setEffect(null);
                    try {
                        //System.out.println("restart");
                        popupStage.hide();
                        new GameRace();
                    }
                    catch(Exception ef)
                    {
//                        System.out.println(ef);
                        ef.printStackTrace();
                    }
                    popupStage.hide();

                });
                popupStage.show();
            }
        };
        //Registering the event filter


        // Score Star
        InputStream stream2 = new FileInputStream(localDir+"\\Star1.png");
        Image image2 = new Image(stream2);
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        imageView2.setX(30);
        imageView2.setY(50);
        imageView2.setFitWidth(80);
        imageView2.setPreserveRatio(true);
        Group root_score_star = new Group(imageView2);
        root.getChildren().add(root_score_star);

        Group root2 = new Group(imageView1);
        root2.addEventFilter(MouseEvent.MOUSE_CLICKED, event);

        root.getChildren().add(root2);
        //root.getChildren().add(root_ball);

    }
}