package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game implements Serializable {
    Group root;
    Scene scene2;
    ArrayList<Obstacle> obstacles;
    ArrayList<Star> stars;
    ArrayList<ColorSwitch> colorSwitches;
    Ball ball;
    User user;
    long score = 0;
    long difficulty = 0;
    long y=0;
    String name;
    // TODO : Add difficulty -> Tushar
    // TODO : Add revive -> Tushar
    // TODO : beautify pause menu -> Tushar nad Rahul
    // TODO : animation on collision -> Rahul
    // TODO : loading game animation -> Tushar and Rahul
    // TODO : sound -> Rahul(Done)
    // TODO : Perfect Collision(75%done)
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
    Text text1;
    double g = 1500;
    double speed = 0.0;
    ArrayList<Group> root_list = new ArrayList<Group>();
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
    public void exitGame(){}
    public void checkCollision(){}
//    public Obstacle getRandomObstacle(){}
    public void setStars(int stars){}
    public void getStars(){}
    public void reviveGame(){}
    public void saveAndExitGame(){}
    Game( Group root, Scene scene, ArrayList<Obstacle> obstalces,
          ArrayList<Star> stars, User user, long score, long difficulty, String name)
    {
        this.root=root;
        this.scene2=scene;
        this.obstacles=obstalces;
        this.stars = stars;
        this.user = user;
        this.score = score;
        this.difficulty = difficulty;
        this.name = name;

    }
    Game() throws FileNotFoundException
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
        Obstacle o = new Obstacle();
        Star star = new Star();
        ColorSwitch colorswitch = new ColorSwitch();
        if(tempO[ind].equals("Ring"))
        {
            o = new Ring();
        }
        if(tempO[ind].equals("Square"))
        {
            o = new Square();

        }
        if(tempO[ind].equals("HorizontalCircles"))
        {
            o = new HorizontalCircles();
        }
        if(tempO[ind].equals("Concentric"))
        {
            o = new ConcentricCircles();
        }
        if(tempO[ind].equals("Triangle"))
        {
            o = new Triangle();
        }
        if(tempO[ind].equals("Lines"))
        {
            o = new HorizontalLine();
        }
        if(tempO[ind].equals("2Plus"))
        {
            o = new TwoPlus();
        }
        if(tempO[ind].equals("Plus"))
        {
            o = new Plus();
        }
        o.show(y);

        obstacles.add(o);
        Group root_square = o.getRoot();
        root.getChildren().add(root_square);
        root_list.add(root_square);
        if(!tempO[ind].equals("Lines"))
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
    public void play() throws FileNotFoundException
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

    public void update(double time, Circle ball_c) throws FileNotFoundException {
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
            obstacles.get(i).blast(ball_c);
        }
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
    public void show() throws FileNotFoundException
    {

        ball = new Ball(); // ball is the object of Ball Class
        Circle ball_c = ball.show();
        Group root_ball = ball.getRoot();
        stars = new ArrayList<Star>();
        colorSwitches = new ArrayList<ColorSwitch>();

        for(int i=0;i<10;i++)
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

        AnimationTimer t = new AnimationTimer(){
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
        // event handler for user control of ball




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
                    timeline.pause();
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
                timeline.pause();
//                timeline1.pause();
                root.setEffect(new GaussianBlur());

                HBox pauseRoot = new HBox(40);
                pauseRoot.setFillHeight(true);
                pauseRoot.getChildren().add(new Label("Paused"));
                pauseRoot.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8);");
                pauseRoot.setAlignment(Pos.CENTER);
                pauseRoot.setPadding(new Insets(20));

                Button resume = new Button("Resume");
                Button exit=new Button("Exit");
                Button save_game=new Button("Save and exit");
                pauseRoot.getChildren().add(resume);
                pauseRoot.getChildren().add(exit);
                pauseRoot.getChildren().add(save_game);
                Stage popupStage = new Stage(StageStyle.TRANSPARENT);
                popupStage.initOwner(Main.stage);
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));

                resume.setOnAction(event -> {
                    root.setEffect(null);
//                    timeline.play();
                    popupStage.hide();
                });

                save_game.setOnAction(event -> {

                    pauseRoot.getChildren().clear();
                    Label label = new Label("Enter name for the game");
                    TextField textField = new TextField();
                    Button but = new Button("Save");
                    pauseRoot.getChildren().add(label);
                    pauseRoot.getChildren().add(textField);
                    pauseRoot.getChildren().add(but);
                    but.setOnAction(eve ->{
                        root.setEffect(null);
                        new MainPage(new Game(root, scene2, obstacles, stars, user, score, difficulty, textField.getText()));
                        popupStage.hide();
                    });
//                    popupStage.hide()
                });

                exit.setOnAction(event -> {
                    root.setEffect(null);
//                    timeline.play();
                    popupStage.hide();
                    try {
                        new MainPage();
                    } catch (FileNotFoundException ex) {
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


//        root.getChildren().add(root6);


        root.getChildren().add(root_ball);

    }

}
