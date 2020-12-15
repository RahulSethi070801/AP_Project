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
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game implements Serializable {
    // serializable objects
    transient Group root;
    transient Scene scene2;
    transient ArrayList<Obstacle> obstacles;
    transient ArrayList<Star> stars;
    
    transient Text text1;
    // transient double g = 1500;
    //  double speed = 0.0;
    transient ArrayList<ColorSwitch> colorSwitches;
    transient Ball ball;
    transient ArrayList<Group> root_list = new ArrayList<Group>();
    transient AnimationTimer t;
    transient AnimationTimer at;
    // serializable objects
    User user;
    long score = 0;
    long difficulty = 0;
    long y=0;
    String name;

    // AnimationTimer at;

    // TODO : beautify pause menu -> Tushar nad Rahul(aur karni ho to)

    // TODO : Add difficulty -> (check)

    // TODO : animation on collision -> Rahul(99%)
    // TODO : loading game animation -> Tushar and Rahul(Done)
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
    double g = 1500;
    double speed = 0.0;
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
    public void getStars(){}
    public void reviveGame(){}
    public void saveAndExitGame()
    {
        try
        {
            new MainPage(new Game(root, scene2, obstacles, stars, user, score, difficulty, name));
        }
        catch(Exception exception){}
    }

    Game( Group root, Scene scene, ArrayList<Obstacle> obstacles,
          ArrayList<Star> stars, User user, long score, long difficulty, String name)
    {
        this.root=root;
        this.scene2=scene;
        this.obstacles=obstacles;
        this.stars = stars;
        this.user = user;
        this.score = score;
        this.difficulty = difficulty;
        this.name = name;

    }

    Game() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        this.name = "NEW GAME";
        root = new Group();
        scene2 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
        this.obstacles = new ArrayList<Obstacle>();
        show();
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
        else if(tempO[ind].equals("Triangle"))
        {
            o = new Triangle();
        }
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
        o.show(y);

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
        root.getChildren().add(colorswitch.show(y-500));
        root_list.add(colorswitch.getRoot());
        colorSwitches.add(colorswitch);
        y-=1000;
//        return y;
    }

    public void play() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
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
        if(this.ball.getLayY()+s<=710)
            this.ball.setLayoutY(s);

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
            difficulty+=10;
            for(int j=0;j<obstacles.size();j++)
            {
                obstacles.get(j).increaseDifficulty(difficulty);
            }
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
            if (obstacles.get(i).blast(ball_c))
            {
                explode(ball);
                //revive();
//                if(score>=0) {
//                    t.stop();
//                    root.setEffect(new GaussianBlur());
////                    System.out.println("REviev");
//                    HBox pauseRoot = new HBox(40);
//                    pauseRoot.setFillHeight(true);
//                    String  style= getClass().getResource("styles.css").toExternalForm();
//                    pauseRoot.getStylesheets().add(style);
//                    Label label = new Label("Revive");
//                    label.setId("paused");
//                    pauseRoot.setId("menu");
//                    pauseRoot.getChildren().add(label);
//                    pauseRoot.setAlignment(Pos.CENTER);
//                    pauseRoot.setPadding(new Insets(20));
//
//                    Button revive = new Button("Revive");
//                    Button restart = new Button("Restart ");
//                    Button exit=new Button("Exit");
//                    revive.setId("resume");
//                    restart.setId("save");
//                    exit.setId("exit");
//                    pauseRoot.getChildren().add(revive);
//                    pauseRoot.getChildren().add(exit);
//                    pauseRoot.getChildren().add(restart);
//                    Stage popupStage = new Stage(StageStyle.TRANSPARENT);
//                    popupStage.initOwner(Main.stage);
//                    popupStage.initModality(Modality.APPLICATION_MODAL);
//                    popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
//
//                    revive.setOnAction(event -> {
//                        root.setEffect(null);
////                    timeline.play();
//                        score-=1;
//                        double minDis=100000;
//                        int ind=-1;
//                        for(int k=0;k<obstacles.size();k++)
//                        {
//                            double diff = ball.getLayY()-obstacles.get(k).getLayoutY();
//                            if (diff<minDis) {
//                                minDis = diff;
//                                ind = k;
//                            }
//                        }
//
//                        if(obstacles.get(ind).getLayoutY()>400)
//                        {
//                            for(int k=0;k<ind-1;k++) {
//                                obstacles.remove(0);
//                            }
//                        }
//                        else{
//                            for(int k=0;k<ind;k++) {
//                                obstacles.remove(0);
//                            }
//                        }
//                        text1.setText(String.valueOf(score));
//                        ball.setLayY(711);
//                        popupStage.hide();
//                        t.start();
//                    });
//
//                    restart .setOnAction(event -> {
//                        root.setEffect(null);
////                    timeline.play();
//                        try {
//                            popupStage.hide();
//                            new Game();
//                        }
//                        catch(Exception e)
//                        {
//                        }
//                        popupStage.hide();
//
//                    });
//                    exit.setOnAction(event -> {
//                        root.setEffect(null);
////                    timeline.play();
//                        popupStage.hide();
//                        try {
//                            new MainPage();
//                        } catch (FileNotFoundException | InterruptedException ex) {
//                            ex.printStackTrace();
//                        }
////                        System.exit(0);
//                    });
//                    popupStage.show();
//                }
//                else {
//                    root.setEffect(null);
////                    timeline.play();
////                    popupStage.hide();
//                    t.stop();
//                    try {
//                        new MainPage();
//                    } catch (FileNotFoundException | InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//
//                    System.out.println("qwebo");
//                    System.exit(0);
//                    root.setEffect(null);
////                    timeline.play();
//                    try {
////                        popupStage.hide();
//                        new Game();
//                    }
//                    catch(Exception e)
//                    {
//                    }
//                    popupStage.hide();
            }
        }
    }


    public void revive()
    {
        if(score>=0) {
            //System.out.println("starting");
            t.stop();
            root.setEffect(new GaussianBlur());
//                    System.out.println("REviev");
            HBox pauseRoot = new HBox(40);
            pauseRoot.setFillHeight(true);
            String  style= getClass().getResource("styles.css").toExternalForm();
            pauseRoot.getStylesheets().add(style);
            Label label = new Label("Revive");
            label.setId("paused");
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
            pauseRoot.getChildren().add(revive);
            pauseRoot.getChildren().add(exit);
            pauseRoot.getChildren().add(restart);
            Stage popupStage = new Stage(StageStyle.TRANSPARENT);
            popupStage.initOwner(Main.stage);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));

            revive.setOnAction(event -> {
                root.setEffect(null);
//                    timeline.play();
                score-=1;
                double minDis=100000;
                int ind=-1;
                for(int k=0;k<obstacles.size();k++)
                {
                    double diff = ball.getLayY()-obstacles.get(k).getLayoutY();
                    if (diff<minDis) {
                        minDis = diff;
                        ind = k;
                    }
                }
                //System.out.println("after for revive");

                if(obstacles.get(ind).getLayoutY()>400)
                {
                    for(int k=0;k<ind-1;k++) {
                        obstacles.remove(0);
                    }
                }
                else{
                    for(int k=0;k<ind;k++) {
                        obstacles.remove(0);
                    }
                }
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
                    new MainPage();
                } catch (FileNotFoundException | InterruptedException ex) {
                    ex.printStackTrace();
                }

            });
            popupStage.show();
        }
        else {
            root.setEffect(null);

            t.stop();
            try {
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

        for (int i=0; i<100; i++)
        {
            Path path = new Path();
            //Arc a1 = new Arc(250, 250, 3,3,0,360);
            Circle c1 = new Circle(688, ball.getLayY(),3);
            c1.setFill(arr.get(getRandom(4)));
            root.getChildren().add(c1);

            MoveTo moveTo = new MoveTo(688, ball.getLayY());
            LineTo lineTo;
            if (i%2==0)
            {
                int x1 = 0;
                int x2 = 700;
                lineTo = new LineTo(getRandom(x2)-x1, getRandom((int)ball.getLayY()+ 500));
            }
            else
            {
                int x1 = 700;
                //int x2 = 1400;
                lineTo = new LineTo(getRandom(x1)+x1, getRandom((int)ball.getLayY()+ 500));
            }

            path.getElements().addAll(moveTo, lineTo);

            PathTransition pt = new PathTransition();
            pt.setDuration(Duration.millis(400 + getRandom(1000)));
            pt.setNode(c1);
            pt.setPath(path);
            parallelTransition.getChildren().add(pt);
        }
        SequentialTransition sq = new SequentialTransition(parallelTransition);
        sq.play();
        t.stop();
        sq.setOnFinished(actionEvent -> revive());
    }

    public void tapBall()
    {
        this.speed = -400;

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
                root_list.get(i).setLayoutY(dey + 5);
            }
        }
    }

    public void show() throws FileNotFoundException, IOException, ClassNotFoundException
    {

        ball = new Ball(); // ball is the object of Ball Class
        Circle ball_c = ball.show();
        Group root_ball = ball.getRoot();
        stars = new ArrayList<Star>();
        colorSwitches = new ArrayList<ColorSwitch>();

        for(int i=0;i<50;i++)
        {
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

        scene2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
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

                HBox pauseRoot = new HBox(40);


                String  style= getClass().getResource("styles.css").toExternalForm();
                pauseRoot.getStylesheets().add(style);
//                pauseRoot.getStylesheets().add(getClass().getResource(localDir+"styles.css").toExternalForm());

                pauseRoot.setFillHeight(true);
                Label paused = new Label("Paused");
                paused.setId("paused");
                pauseRoot.getChildren().add(paused);
//                pauseRoot.setStyle(
//
//                );
                pauseRoot.setId("menu");
                pauseRoot.setAlignment(Pos.CENTER);
                pauseRoot.setPadding(new Insets(20));

                pauseRoot.setEffect(new DropShadow(20, Color.BLACK));

                Button resume = new Button("Resume");
                Button exit=new Button("Exit");
                Button save_game=new Button("Save and exit");
                resume.setId("resume");
                exit.setId("exit");
                exit.setEffect(new DropShadow(20, Color.BLACK));
                resume.setEffect(new DropShadow(20, Color.BLACK));
                save_game.setEffect(new DropShadow(20, Color.BLACK));
                save_game.setId("save");
                pauseRoot.getChildren().add(resume);
                pauseRoot.getChildren().add(exit);
                pauseRoot.getChildren().add(save_game);
                Stage popupStage = new Stage(StageStyle.TRANSPARENT);
                popupStage.initOwner(Main.stage);
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));

                popupStage.setX(500);
                popupStage.setY(300);
                resume.setOnAction(event -> {
                    root.setEffect(null);
//                    timeline.play();
                    t.start();
                    popupStage.hide();
                });

                save_game.setOnAction(event -> {

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
//                    popupStage.hide()
                });

                exit.setOnAction(event -> {
                    root.setEffect(null);
//                    timeline.play();
                    popupStage.hide();
                    try {
                        new MainPage();
                    } catch (FileNotFoundException | InterruptedException ex) {
                        ex.printStackTrace();
                    }
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
            out = new ObjectOutputStream( new FileOutputStream("tush.txt"));
            out.writeObject(this);
        }
        finally
        {
            out.close();
        }

    }
}
/*      Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10),
                new EventHandler<ActionEvent>() {
                    double dy = -10; //Step on y
                    @Override
                    public void handle(ActionEvent t) {

                        ball.setLayoutY( dy);
                        ball.getLayY();
                        if(ball.getLayY()<500) {
                            for (int i = 0; i < root_list.size(); i++) {
                                double dey = root_list.get(i).getLayoutY();
                                root_list.get(i).setLayoutY(dey - dy);
//                                if (root_list.get(i).getLayoutY() > 1200)
//                                {
//                                    root_list.remove(i);
//                                }
                            }
                        }
                        Bounds bounds = root.getBoundsInLocal();
                        double curr = ball.getLayY();

                        if (obstacles.get(0).getLayoutY() > curr + 800)
                        {
                            System.out.println("out");
                            obstacles.remove(0);
                            try {
                                addObstacle();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i=0; i<2; i++)
                        {
                            obstacles.get(i).blast(ball_c);
                        }

                        if (isCollide(ball, colorSwitches.get(0).getRoot()))
                        {
                            //System.out.println("touch");
                            while (true)
                            {
                                if (getRandom(4) == 0)
                                {
                                    continue;
                                }
                                if (getRandom(4) == 1)
                                {
                                    ball.setFill(Color.rgb (250, 225, 0));
//                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 2)
                                {
                                    ball.setFill(Color.rgb(50, 219, 240));
//                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 3)
                                {
                                    ball.setFill(Color.rgb(255, 1, 129));
//                                    root.getChildren().remove(root5);
                                    break;
                                }
                                root.getChildren().remove(colorSwitches.get(0).getRoot());
                                root_list.remove(colorSwitches.get(0).getRoot());
                                colorSwitches.remove(0);
                            }
                        }
                        if (isCollide(ball, stars.get(0).getRoot()))
                        {
                            //System.out.println("touch");
                            root.getChildren().remove(stars.get(0).getRoot());
                            root_list.remove(stars.get(0).getRoot());
                            stars.remove(0);
                            text1.setText(String.valueOf(++score));
                        }
//                                if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
//                                        (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){
//
//                                    dy = -dy;
//                                } q
                    }
                }));
        timeline1.setCycleCount(20);
*/
// event handler for user control of
// ball

/*
// timeline for ball
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {

                    double dx = 7; //Step on x or velocity
                    double dy = 7; //Step on y

                    @Override
                    public void handle(ActionEvent t) {

                        ball.setLayoutY(dy);

                        if(ball.getLayY()<500) {
                            for (int i = 0; i < root_list.size(); i++) {
                                double dey = root_list.get(i).getLayoutY();
                                root_list.get(i).setLayoutY(dey + dy);
//                                if (root_list.get(i).getLayoutY() > 1200)
//                                {
//                                    root_list.remove(i);
//                                }
                            }
                        }
                        //double curr = ball.getLayY();

//                        if (obstacles.get(0).getLayoutY() >  1200)
//                        {
//                            obstacles.remove(0);
//                            try {
//                                addObstacle();
//                            } catch (FileNotFoundException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        for (int i=0; i<3; i++)
//                        {
//                            obstacles.get(i).blast(ball_c);
//                        }

                        if (isCollide(ball, colorSwitches.get(0).getRoot()))
                        {
                            //System.out.println("touch");
                            while (true)
                            {
                                if (getRandom(4) == 0)
                                {
                                    continue;
                                }
                                if (getRandom(4) == 1)
                                {
                                    ball.setFill(Color.rgb (250, 225, 0));
                                    ball.setColor(Color.rgb (250, 225, 0));
//                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 2)
                                {
                                    ball.setFill(Color.rgb(50, 219, 240));
                                    ball.setColor(Color.rgb(50, 219, 240));
//                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 3)
                                {
                                    ball.setFill(Color.rgb(255, 1, 129));
                                    ball.setColor(Color.rgb(255, 1, 129));
//                                    root.getChildren().remove(root5);
                                    break;
                                }
                                root.getChildren().remove(colorSwitches.get(0).getRoot());
                                root_list.remove(colorSwitches.get(0).getRoot());
                                colorSwitches.remove(0);
                            }
                        }
                        //Bounds bounds = root.getBoundsInParent();
//                        System.out.println(bounds);
//
//                        if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
//                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){
//                            System.out.println("Hello");
//                            dy = -dy;
//
//                        }
                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);


 */