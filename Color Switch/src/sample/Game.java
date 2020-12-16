package sample;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.animation.*;
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

import java.awt.event.ActionListener;
import java.beans.Transient;
import java.io.*;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Random;

public class Game implements Serializable {
    // serializable objects
    transient Group root;
    transient Scene scene2;
    transient ArrayList<Group> root_list = new ArrayList<Group>();
    transient Ball ball;
    transient AnimationTimer t;
    transient AnimationTimer at;
    transient Text text1;

    ArrayList<Obstacle> obstacles;
    ArrayList<Star> stars;
    ArrayList<ColorSwitch> colorSwitches;
    double g = 1500;
    double speed = 0.0;
    User user;
    long score = 0;
    long difficulty = 0;
    long y=0;
    String name;
    boolean newGame = true;
    transient int ind = -1;
    public void setupGame()
    {
        ind=-1;
        root_list = new ArrayList<Group>();
        System.out.println("starting obstacles");
        System.out.println(obstacles);
        for(int i=0;i<obstacles.size();i++)
        {
            Obstacle o = obstacles.get(i);
//            System.out.println("beofre "+o.y);
            o.show((long)o.y, difficulty);
            difficulty+=500;
            root.getChildren().add(o.getRoot());
            root_list.add(o.getRoot());
            System.out.println(obstacles.get(i).y+" "+obstacles.get(i)+" setup");
        }
        System.out.println("starting stars");
        for(int i=0;i<stars.size();i++)
        {
            try {
                Star star = stars.get(i);
                root.getChildren().add(star.show((double)675, star.y));
                root_list.add(star.getRoot());
                System.out.println(stars.get(i).y+" "+stars.get(i).getClass());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("starting colorswtiches");

        for(int i=0;i<colorSwitches.size();i++)
        {
            ColorSwitch colorswitch = colorSwitches.get(i);
//            System.out.println(colorSwitches);
            root.getChildren().add(colorswitch.show((long)colorswitch.y));
            root_list.add(colorswitch.getRoot());
            System.out.println(colorSwitches.get(i).y+" "+colorSwitches.get(i).getClass());

        }

//        this.play();
    }
//    ArrayList<Integer> obstaclesSerializable;
//    ArrayList<Integer> starsSerialzable;
//    ArrayList<Integer> colorSwitchesSerializable;

    // TODO : Add difficulty -> Tushar DONE (under review)
    // TODO : Add revive -> Tushar DONE
    // TODO : beautify pause menu -> Tushar nad Rahul DONE
    // TODO : animation on collision -> Rahul
    // TODO : loading game animation -> Tushar and Rahul
    // TODO : sound -> Rahul(Done)

    // TODO : Intermediate Page btw collision and revive
    Random rand = new Random();
    String tempO[] = {
            "Ring",
            "Square",
            "Triangle",
            "Concentric",
            "HorizontalCircles",
            "Lines",
            "2Plus",
            "Plus"
    };
    // Text text1;
//    double g = 1500;
//    double speed = 0.0;
    // ArrayList<Group> root_list = new ArrayList<Group>();
    public void resumeGame(){}
    public void pauseGame(){}
//    public Ball getBall(){}
    public void setBall(){}
//    public Obstacle getCurrentObstacle(){}
    public void setCurrentObstacle(Obstacle obstacle){}
    public long getDifficulty()
    {
        return this.difficulty;
    }
    public void setDifficulty(){}
    public void playGame(){}
    public void setBackground(){}
    public void controlBall(){}
    public void exitGame(){
        try {
            new MainPage();
        }
        catch (Exception e)
        {}
    }
    public void checkCollision(){}
//    public Obstacle getRandomObstacle(){}
    public void setStars(int stars){}
    public double getStars(){
        return this.score;
    }
    public void reviveGame(){}
    public void saveAndExitGame()
    {
        try
        {
            System.out.println("Before calling save");
            System.out.println(obstacles);
            for(int i=0;i<obstacles.size();i++)
            {
                System.out.println(obstacles.get(i).y+" "+obstacles.get(i)+" before saving");
            }
            save();
            new MainPage();
        }
        catch(Exception exception){

        }
    }

    Game(Group root, Scene scene, ArrayList<Obstacle> obstacles,
         ArrayList<Star> stars, User user, long score, long difficulty, String name,
         ArrayList<ColorSwitch> colorSwitches, ArrayList<Group> root_list)
    {
        this.root=root;
        this.scene2=scene;
        this.obstacles=obstacles;
        this.stars = stars;
        this.user = user;
        this.score = score;
        this.difficulty = difficulty;
        this.name = name;
        this.root_list = root_list;
        this.colorSwitches = colorSwitches;
    }

    Game() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        this.name = "NEW GAME";
        root = new Group();
        scene2 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
        this.obstacles = new ArrayList<Obstacle>();
        System.out.println(root+" root new");
        System.out.println(scene2+" scene2 new");
        show();
    }

    Game(Game game) throws FileNotFoundException, IOException, ClassNotFoundException
    {
//        root = new Group();
        game.root = new Group();
        game.scene2 = new Scene(game.root, 1600, 1050, Color.BLACK);
        Main.stage.setScene(game.scene2);
        Main.stage.setX(-25);
        Main.stage.setY(-35);
//        Main.stage.setFullScreen(true);
//        this.obstacles = new ArrayList<Obstacle>();
//        game.show();
    }

    public void addObstacle() throws FileNotFoundException
    {
        int ind = rand.nextInt(8);
//            int ind = 0;
        Obstacle o;// = new Obstacle();
        Star star = new Star();
        ColorSwitch colorswitch = new ColorSwitch();
        if(tempO[ind].equals("Ring"))
        {
            o = new Ring();
        }
        else if(tempO[ind].equals("Square"))
        {
            o = new Square();

        }
        else if(tempO[ind].equals("HorizontalCircles"))
        {
            o = new HorizontalCircles();
        }
        else if(tempO[ind].equals("Concentric"))
        {
            o = new ConcentricCircles();
        }
//        else if(tempO[ind].equals("Triangle"))
//        {
//            o = new Triangle();
//        }
//        else if(tempO[ind].equals("Lines"))
//        {
//            o = new HorizontalLine();
//        }
        else if(tempO[ind].equals("2Plus"))
        {
            o = new TwoPlus();
        }
        else if(tempO[ind].equals("Plus"))
        {
            o = new Plus();
        }
        else
            o = new Ring();
        o.show(y, difficulty);
        difficulty -= 500;
        System.out.println(o.y+" "+o.getClass());
        obstacles.add(o);
        Group root_square = o.getRoot();
        root.getChildren().add(root_square);
        root_list.add(root_square);
        if(!tempO[ind].equals("qwe"))
        {
            root.getChildren().add(star.show((double)675, (double)y+375));
            root_list.add(star.getRoot());
            stars.add(star);
        }
        root.getChildren().add(colorswitch.show(y-250));
        root_list.add(colorswitch.getRoot());
        colorSwitches.add(colorswitch);

        y-=500;
//        return y;
    }

    public void play() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        root = new Group();
        scene2 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
        System.out.println(root+" root saved");
        System.out.println(scene2+" scene2 saved");
        this.show();
    }

    Game(String name)
    {
        this.name = name;
    }

    public int getRandom(int n)
    {
        Random rand = new Random();
        return rand.nextInt(n);
    }

    public static boolean isCollide(Ball x, Group y)
    {
        Bounds RectA = x.localToScene();
        Bounds RectB = y.localToScene(y.getBoundsInLocal());

        return RectB.intersects(RectA);
    }

    public void update(double time, Circle ball_c) throws FileNotFoundException
    {
        // s = ut+0.5at^2
//        System.out.println(time);
        time/=Math.pow(10,9);
        this.speed += this.g*time;
        double s = (this.speed*time + 0.5*this.g*Math.pow(time,2));
//        System.out.println(this.ball.getLayY()+" "+s);
        if(this.ball.getLayY()+s<=710) {
            this.ball.setLayoutY(s);
        }

        if (isCollide(ball, colorSwitches.get(0).getRoot()))
        {
            //System.out.println("touch");
            while (true)
            {
                if (getRandom(4) == 0)
                {
                    if (ball.getFill().equals(Color.rgb(144, 13, 255)))
                    continue;
                    else
                    {
                        ball.setFill(Color.rgb(144, 13, 255));
                        break;
                    }
                }
                if (getRandom(4) == 1)
                {
                    if (ball.getFill().equals((Color.rgb (250, 225, 0))))
                        continue;
                    else
                    {
                        ball.setFill(Color.rgb (250, 225, 0));
                        break;
                    }
                }
                if (getRandom(4) == 2)
                {
                    if (ball.getFill().equals((Color.rgb(50, 219, 240))))
                        continue;
                    else
                    {
                        ball.setFill(Color.rgb(50, 219, 240));
                        break;
                    }
                }
                if (getRandom(4) == 3)
                {
                    if (ball.getFill().equals((Color.rgb(255, 1, 129))))
                        continue;
                    else
                    {
                        ball.setFill(Color.rgb(255, 1, 129));
                        break;
                    }
                }
            }
            String localDir = System.getProperty("user.dir");
            String path = localDir+"\\colorswitch.wav";
            Media media = new Media(new File(path).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);

            root.getChildren().remove(colorSwitches.get(0).getRoot());
            root_list.remove(colorSwitches.get(0).getRoot());
            colorSwitches.remove(0);
        }
        if (isCollide(ball, stars.get(0).getRoot()))
        {
            //System.out.println("touch");
            difficulty+=1000;
            // for(int j=0;j<obstacles.size();j++)
            // {
            //     obstacles.get(j).increaseDifficulty(difficulty);
            // }
            root.getChildren().remove(stars.get(0).getRoot());
            root_list.remove(stars.get(0).getRoot());
            stars.remove(0);
            text1.setText(String.valueOf(++score));

            String localDir = System.getProperty("user.dir");
            String path = localDir+"\\star.wav";
            Media media = new Media(new File(path).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
        }
        /*if (obstacles.get(0).getLayoutY() > 800)
        {
            System.out.println("a");
            obstacles.remove(0);
            addObstacle();
        }*/
        //System.out.println(obstacles.size());
        for (int i=0; i<obstacles.size(); i++)
        {
//            System.out.println(this.obstacles.get(i)+" obstacle "+this.obstacles.get(i).getLayoutY());
            if (obstacles.get(i).blast(ball_c))
            {
                String localDir = System.getProperty("user.dir");
                String path = localDir+"\\dead.wav";
                Media media = new Media(new File(path).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
                this.ind = i;
                explode(ball);
            }
        }
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

            Button revive = new Button("Revive");
            Button restart = new Button("Restart ");
            Button exit=new Button("Exit");
            revive.setId("resume");
            restart.setId("save");
            exit.setId("exit");
            revive.setEffect(new DropShadow(20, Color.BLACK));
            restart.setEffect(new DropShadow(20, Color.BLACK));
            exit.setEffect(new DropShadow(20, Color.BLACK));
            pauseRoot.getChildren().add(revive);
            pauseRoot.getChildren().add(exit);
            pauseRoot.getChildren().add(restart);
            pauseRoot.setEffect(new DropShadow(20, Color.BLACK));
            Stage popupStage = new Stage(StageStyle.TRANSPARENT);
            popupStage.initOwner(Main.stage);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));

            popupStage.setX(500);
            popupStage.setY(250);
            revive.setOnAction(event -> {
                join(ball);

                root.setEffect(null);
//                    timeline.play();
                score-=1;
                double minDis=100000;
//                int ind=-1;

                System.out.println(ball.getLayY()+" ball y");

//                for(int k=0;k<obstacles.size();k++)
//                {
//                    if(obstacles.get(k).y+root_list.get(root_list.indexOf(obstacles.get(k).getRoot())).getLayoutY()>=400)
//                    {
//                        ind = k;
//                    }
////                    double diff = ball.getLayY()-obstacles.get(k).y-root_list.get(root_list.indexOf(obstacles.get(k).getRoot())).getLayoutY();
////                    System.out.println(diff+" distances");
////                    if (diff<minDis) {
////                        minDis = diff;
////                        ind = k;
////                    }
//                }

                System.out.println(ind + " ind");
                if(ind >=0)
                {
                    for(int i=0;i<=ind;i++){
                        System.out.println("removing "+obstacles.get(0)+" "+obstacles.get(0).getClass()+" "+obstacles.get(i).y+" "+root_list.get(root_list.indexOf(obstacles.get(i).getRoot())).getLayoutY());
                        root.getChildren().remove(obstacles.get(0).getRoot());
                        root_list.remove(obstacles.get(0).getRoot());
                        obstacles.remove(0);
                    }
                    ind=-1;
                }
//                if(ind >=0 && obstacles.get(ind).y+root_list.get(root_list.indexOf(obstacles.get(ind).getRoot())).getLayoutY()>=400)
//                {
//                    System.out.println("if");
//                    for(int k=0;k<=ind;k++) {
////                        System.out.println("before removing "+obstacles.get(0));
//                        root.getChildren().remove(obstacles.get(0).getRoot());
//                        root_list.remove(obstacles.get(0).getRoot());
//                        obstacles.remove(0);
////                        System.out.println("after removing "+obstacles.get(0));
//                    }
//                }
//                else if (ind>=0){
//                    System.out.println("else");
//                    for(int k=0;k<=ind;k++) {
//                        if(obstacles.get(0).y+root_list.get(root_list.indexOf(obstacles.get(0).getRoot())).getLayoutY()>400) {
//                            System.out.println("removing " + obstacles.get(0) + " " + obstacles.get(0).getClass());
//                            root.getChildren().remove(obstacles.get(0).getRoot());
//                            root_list.remove(obstacles.get(0).getRoot());
//                            obstacles.remove(0);
//                        }
//                    }
//                }
//                System.out.println("after removeing obstacles");
//                System.out.println(obstacles);
//                for(int i=0;i<this.obstacles.size();i++)
//                {
//                    System.out.println(this.obstacles.get(i).y+" "+this.obstacles.get(i)+" onscroll");
//                }
                text1.setText(String.valueOf(score));
                ball.setLayY(711);
                popupStage.hide();
                t.start();
            });

            restart.setOnAction(event -> {
                root.setEffect(null);
                try {
                    //System.out.println("restart");
                    popupStage.hide();
                    Main.user.totalScore += score;
                    if(Main.user.highestScore < score)
                        Main.user.highestScore = score;
                    new Game();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                popupStage.hide();

            });
            exit.setOnAction(event -> {
                root.setEffect(null);
                popupStage.hide();
                try {
                    Main.user.totalScore += score;
                    if(Main.user.highestScore < score)
                        Main.user.highestScore = score;
                    new MainPage();
                } catch (FileNotFoundException | InterruptedException ex) {
                    ex.printStackTrace();
                    System.out.println("Game Over");
                }

            });
            popupStage.show();
        }
        else {
            root.setEffect(null);
            t.stop();
            try {
                Main.user.totalScore += score;
                if(Main.user.highestScore < score)
                    Main.user.highestScore = score;
                new MainPage();
            } catch (FileNotFoundException | InterruptedException ex) {
                ex.printStackTrace();
            }

            //System.out.println("qwebo");
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
        //root.getChildren().remove(root3);
        t.stop();
        sq.setOnFinished(actionEvent -> revive());
    }

    public void join(Ball ball)
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

            MoveTo moveTo;

            if (i%2==0)
            {
                int x1 = 0;
                int x2 = 700;
                moveTo = new MoveTo(getRandom(x2)-x1, getRandom((int)ball.getLayY()+ 500));
            }
            else
            {
                int x1 = 700;
                //int x2 = 1400;
                moveTo = new MoveTo(getRandom(x1)+x1, getRandom((int)ball.getLayY()+ 500));
            }

            LineTo lineTo = new LineTo(688, 700);

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
//        EventHandler<ActionEvent> punar_janam = actionEvent ->
//        {
//            for(Node i : root3.getChildren())
//            {
//                root3.getChildren().remove(i);
//            }
//            //t.stop();
//        };
//        sq.setOnFinished(punar_janam);

        //sq.setOnFinished(actionEvent -> revive());
    }

    public void tapBall()
    {
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
        if(ball.getLayY()<375) {
            for (int i = 0; i < root_list.size(); i++) {
                double dey = root_list.get(i).getLayoutY();
//                System.out.println(dey + " dey");
                root_list.get(i).setLayoutY(dey + 2);
            }
        }
    }

    int counter=0;
    public void show() throws FileNotFoundException, IOException, ClassNotFoundException
    {

        ball = new Ball(); // ball is the object of Ball Class
        Circle ball_c = ball.show();
        Group root_ball = ball.getRoot();

        if(newGame) {
            stars = new ArrayList<Star>();
            colorSwitches = new ArrayList<ColorSwitch>();

            for (int i = 0; i < 25; i++) {
                addObstacle();
            }
        }
        else{
            System.out.println("Start");
            this.setupGame();
            System.out.println("End");
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

//                System.out.println("Down");
                //Ball Update
                long elapsed = now - lastUpdate;
                try {
                    update(elapsed, ball_c);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                scroll();
//                checkCollisions();
//                generalGenerate();

                lastUpdate = now;
            }
        };

//        int counter = 0;
        scene2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.Q) {
//                final int ctr=counter;
//                System.out.println("UP"+ctr);
//                counter++;
                tapBall();
            }
        });

        t.start();
        // Show Pause button
        InputStream stream1 = new FileInputStream(localDir+"\\Pause.png");
        Image image1 = new Image(stream1);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(1400);
        imageView1.setY(50);
        imageView1.setFitWidth(100);
        imageView1.setPreserveRatio(true);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
//                Bounds bounds = root.getBoundsInParent();
                //System.out.println("Pause");
//                polygon.setFill(Color.DARKSLATEBLUE);
                try {
//                    t.pause();
//                    timeline1.pause();
                    new PauseMenu();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        };

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
                Button save_game=new Button("Save and exit");
                Button restart = new Button("Restart ");
                resume.setId("resume");
                restart.setId("resume");
                exit.setId("exit");
                exit.setEffect(new DropShadow(20, Color.BLACK));
                restart.setEffect(new DropShadow(20, Color.BLACK));
                resume.setEffect(new DropShadow(20, Color.BLACK));
                save_game.setEffect(new DropShadow(20, Color.BLACK));
                save_game.setId("save");
                pauseRoot.getChildren().add(resume);
                pauseRoot.getChildren().add(restart);
                pauseRoot.getChildren().add(save_game);
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

                save_game.setOnAction(event -> {
                    Main.user.totalScore += score;
                    if(Main.user.highestScore < score)
                        Main.user.highestScore = score;
                    pauseRoot.getChildren().clear();
                    Label label = new Label("Enter Name");
                    label.setId("paused");
                    TextField textField = new TextField();
                    Button but = new Button("Save");
                    but.setId("save");
                    pauseRoot.getChildren().add(label);
                    pauseRoot.getChildren().add(textField);
                    pauseRoot.getChildren().add(but);
                    but.setOnAction(eve ->{
                        root.setEffect(null);
                        name = textField.getText();
                        popupStage.hide();
                        saveAndExitGame();
                    });
                });

                exit.setOnAction(event -> {
                    root.setEffect(null);
                    popupStage.hide();
                    try {
                        Main.user.totalScore += score;
                        if(Main.user.highestScore < score)
                            Main.user.highestScore = score;
                        new MainPage();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                restart.setOnAction(event -> {
                    root.setEffect(null);
                    try {
                        Main.user.totalScore += score;
                        if(Main.user.highestScore < score)
                            Main.user.highestScore = score;
                        //System.out.println("restart");
                        popupStage.hide();
                        new Game();
                    }
                    catch(Exception ef)
                    {
                        System.out.println(ef);
                    }
                    popupStage.hide();

                });
                popupStage.show();
            }
        };
        //Registering the event filter


        // Score Star
        InputStream stream2 = new FileInputStream(localDir+"\\Star.jpg");
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
        root.getChildren().add(root_ball);

    }

    public void save() throws IOException, ClassNotFoundException
    {
        ObjectOutputStream out = null;
        try
        {
            out = new ObjectOutputStream( new FileOutputStream(name+".txt"));
            System.out.println(obstacles);
            for(int i=0;i<this.obstacles.size();i++)
            {
//                System.out.println(this.obstacles.get(i).y+" "+this.obstacles.get(i)+" y before");
                double temp = this.obstacles.get(i).y+this.root_list.get(this.root_list.indexOf(this.obstacles.get(i).getRoot())).getLayoutY();
                this.obstacles.get(i).y = temp;
                System.out.println(this.obstacles.get(i).y+" "+this.obstacles.get(i)+" saving ");
            }
            for(int i=0;i<this.stars.size();i++)
            {
                double temp = this.stars.get(i).y+this.root_list.get(this.root_list.indexOf(this.stars.get(i).getRoot())).getLayoutY();
                this.stars.get(i).y = temp;
                System.out.println(this.stars.get(i).y+" "+this.stars.get(i).getClass());
            }
            for(int i=0;i<this.colorSwitches.size();i++)
            {
                double temp = this.colorSwitches.get(i).y+this.root_list.get(this.root_list.indexOf(this.colorSwitches.get(i).getRoot())).getLayoutY();
                this.colorSwitches.get(i).y = temp;
                System.out.println(this.colorSwitches.get(i).y+" "+this.colorSwitches.get(i).getClass());
            }
            out.writeObject(this);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Yahan");
        }
        finally
        {
            out.close();
        }

    }
}