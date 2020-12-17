
    // TODO : Add difficulty -> Tushar DONE (under review) (DONE)
    // TODO : Add revive -> Tushar DONE
    // TODO : beautify pause menu -> Tushar nad Rahul DONE
    // TODO : animation on collision -> Rahul (DONE)
    // TODO : loading game animation -> Tushar and Rahul (DONE)
    // TODO : sound -> Rahul(Done)

    // TODO : Intermediate Page btw collision and revive (DONE)
package sample;

import javafx.animation.*;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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
import java.util.Random;

public class Game implements Serializable {
    // non serializable objects
    private transient Group root;
    private transient Scene scene2;
    private transient ArrayList<Group> root_list = new ArrayList<Group>();
    private transient Ball ball;
    private transient AnimationTimer t;
    private transient AnimationTimer at;
    private transient Text text1;
    private transient int ind = -1;
    // serializable objects
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Star> stars;
    private ArrayList<ColorSwitch> colorSwitches;
    private double g = 1500;
    private double speed = 0.0;
    private User user;
    private long score = 0;
    private long difficulty = 0;
    private long y=0;
    private String name;
    private boolean newGame = true;
    private Random rand = new Random();
    private String tempO[] = {
            "Ring",
            "Square",
            "Triangle",
            "Concentric",
            "HorizontalCircles",
            "Lines",
            "2Plus",
            "Plus"
    };

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

    Game(String name)
    {
        this.name = name;
    }

    public void setNewGameFalse() {
        this.newGame=false;
    }

    public String getName()
    {
        return this.name;
    }

    public void setupGame()
    {
        ind=-1;
        root_list = new ArrayList<Group>(); // initialising a new root_list to store all the roots of the components in the game

        for(int i=0;i<obstacles.size();i++)
        {
            Obstacle o = obstacles.get(i);
            o.show((long)o.y, difficulty);
            difficulty+=500;
            root.getChildren().add(o.getRoot());
            root_list.add(o.getRoot());
            // System.out.println(obstacles.get(i).y+" "+obstacles.get(i)+" setup");
        }

        for(int i=0;i<stars.size();i++)
        {
            try {
                Star star = stars.get(i);
                root.getChildren().add(star.show((double)675, star.getY()));
                root_list.add(star.getRoot());
                // System.out.println(stars.get(i).y+" "+stars.get(i).getClass());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        for(int i=0;i<colorSwitches.size();i++)
        {
            ColorSwitch colorswitch = colorSwitches.get(i);
            root.getChildren().add(colorswitch.show((long)colorswitch.getLayoutY()));
            root_list.add(colorswitch.getRoot());
            // System.out.println(colorSwitches.get(i).getLayoutY()+" "+colorSwitches.get(i).getClass());
        }
    }

    public void resumeGame(){}
    public void pauseGame(){}
    public void setBall(){}
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
    public void setStars(int stars){}
    public double getStars(){
        return this.score;
    }
    public void reviveGame(){}

    public void saveAndExitGame()
    {
        try
        {
            save();
            new MainPage();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public void addObstacle() throws FileNotFoundException
    {
        int ind = getRandom(8);
        Obstacle o;
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
        else if(tempO[ind].equals("Lines"))
        {
            o = new HorizontalLine();
        }
        else if(tempO[ind].equals("2Plus"))
        {
            o = new TwoPlus();
        }
        else if(tempO[ind].equals("Plus"))
        {
            o = new Plus();
        }
        else
            o = new HorizontalLine();

        o.show(y, difficulty);
        obstacles.add(o);

        Group root_square = o.getRoot();
        root.getChildren().add(root_square);
        root_list.add(root_square);
        //add star
        root.getChildren().add(star.show((double)675, (double)y+375));
        root_list.add(star.getRoot());
        stars.add(star);
        //add obstacle
        root.getChildren().add(colorswitch.show(y-250));
        root_list.add(colorswitch.getRoot());
        colorSwitches.add(colorswitch);

        difficulty -= 500;
        y-=500;
    }

    public void play() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        root = new Group();
        scene2 = new Scene(root, 800, 800, Color.BLACK);
        Main.stage.setScene(scene2);
        Main.stage.setFullScreen(true);
        this.show();
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
            mediaPlayer.setAutoPlay(Main.sound);
//            mediaPlayer.setCycleCount();

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
            mediaPlayer.setAutoPlay(Main.sound);
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
                mediaPlayer.setAutoPlay(Main.sound);
                this.ind = i;
                explode(ball);
            }
        }
    }

    public void revive()
    {
        if(score>=2) {
            t.stop(); // stop the animation timer
            root.setEffect(new GaussianBlur()); // make the scene blurred

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
            Label label = new Label("Game Over");
            label.setId("paused");
            label.setEffect(new DropShadow(20,Color.BLACK));
            pauseRoot.getChildren().add(label);
            // adding score
            Label scorelabel = new Label("Score : "+score);
            scorelabel.setId("paused");
            scorelabel.setEffect(new DropShadow(20,Color.BLACK));
            pauseRoot.getChildren().add(scorelabel);
            //adding revive button
            Button revive = new Button("Revive");
            revive.setId("resume");
            revive.setEffect(new DropShadow(20, Color.BLACK));
            pauseRoot.getChildren().add(revive);
            //adding restart
            Button restart = new Button("Restart ");
            restart.setId("save");
            restart.setEffect(new DropShadow(20, Color.BLACK));
            pauseRoot.getChildren().add(restart);
            //adding exit
            Button exit=new Button("Exit");
            exit.setId("exit");
            exit.setEffect(new DropShadow(20, Color.BLACK));
            pauseRoot.getChildren().add(exit);
            // make a stage
            Stage popupStage = new Stage(StageStyle.TRANSPARENT);
            popupStage.initOwner(Main.stage);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));
            popupStage.setX(500);
            popupStage.setY(250);

            revive.setOnAction(event -> {
                join(ball);
                root.setEffect(null);
                score-=1;
                double diff = 711-ball.getLayY();

                if(ind >=0)
                {
                    for(int i=0;i<=ind;i++){
                        root.getChildren().remove(obstacles.get(0).getRoot());
                        root_list.remove(obstacles.get(0).getRoot());
                        obstacles.remove(0);
                    }
                    ind=-1;
                }

                for(int i=0;i<root_list.size();i++)
                {
                    double dey = root_list.get(i).getLayoutY();
                    root_list.get(i).setLayoutY(dey + diff);
                }

                text1.setText(String.valueOf(score)); //increment the score on the screen

                ball.setLayY(711);
                popupStage.hide();
                t.start(); // start the actiontimer again
            });

            restart.setOnAction(event -> {
                root.setEffect(null);
                try {
                    popupStage.hide();
                    Main.user.incrementTotalScore(score);
                    if(Main.user.getHighestScore() < score)
                        Main.user.setHighestScore(score);
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
                    Main.user.incrementTotalScore(score);
                    if(Main.user.getHighestScore() < score)
                        Main.user.setHighestScore(score);
                    new MainPage();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Game Over");
                }

            });

            popupStage.show();
        }
        else {
//            root.setEffect(null);
            t.stop();
            try {
                Main.user.incrementTotalScore(score);
                if(Main.user.getHighestScore() < score)
                    Main.user.setHighestScore(score);

                VBox scoreBoard = new VBox(40);
                scoreBoard.setFillWidth(true);
                scoreBoard.setId("menu");
                scoreBoard.setAlignment(Pos.CENTER);
                scoreBoard.setPadding(new Insets(20));
                scoreBoard.setEffect(new DropShadow(20, Color.BLACK));

                String  style= getClass().getResource("styles.css").toExternalForm();
                scoreBoard.getStylesheets().add(style);

                Label label = new Label("GAME OVER" );
                label.setId("paused");
                label.setEffect(new DropShadow(20,Color.BLACK));
                scoreBoard.getChildren().add(label);

                Label scoreLabel = new Label("SCORE : "+score);
                scoreLabel.setId("paused");
                scoreLabel.setEffect(new DropShadow(20,Color.BLACK));
                scoreBoard.getChildren().add(scoreLabel);

                Button restart = new Button("Restart");
                restart.setId("resume");
                restart.setEffect(new DropShadow(20, Color.BLACK));
                scoreBoard.getChildren().add(restart);

                Button exit = new Button("Exit");
                exit.setId("exit");
                exit.setEffect(new DropShadow(20, Color.BLACK));
                scoreBoard.getChildren().add(exit);

                Stage popupStage = new Stage(StageStyle.TRANSPARENT);
                popupStage.initOwner(Main.stage);
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.setScene(new Scene(scoreBoard, Color.TRANSPARENT));
                popupStage.setX(450);
                popupStage.setY(250);

                restart.setOnAction(event -> {
                    root.setEffect(null);
                    try {
                        popupStage.hide();
                        Main.user.incrementTotalScore(score);
                        if(Main.user.getHighestScore() < score)
                            Main.user.setHighestScore(score);
                        new Game();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    popupStage.hide();

                });

                exit.setOnAction(event -> {
                    popupStage.hide();
                    try {
                        new MainPage();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                });
                popupStage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
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
                lineTo = new LineTo(getRandom(x1)+x1 + 1000, getRandom((int)ball.getLayY()+ 1000));
            }

            path.getElements().addAll(moveTo, lineTo);

            PathTransition pt = new PathTransition();
            pt.setDuration(Duration.millis(400 + getRandom(1000)));
            pt.setNode(c1);
            pt.setPath(path);
            parallelTransition.getChildren().add(pt);
        }
        ball.setFill(Color.BLACK);
        ball.setFill(Color.TRANSPARENT);
        root.getChildren().add(root3);
        SequentialTransition sq = new SequentialTransition(parallelTransition);
        sq.play();
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

        //Group root3 = new Group();
        ArrayList<Group> smallballs = new ArrayList<>();

        for (int i=0; i<1000; i++)
        {
            Path path = new Path();
            //Arc a1 = new Arc(250, 250, 3,3,0,360);
            Circle c1 = new Circle(688, ball.getLayY(),3);
            c1.setFill(arr.get(getRandom(4)));
            Group temp = new Group(c1);
            root.getChildren().add(temp);
            smallballs.add(temp);
            //root3.getChildren().add(c1);

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

            LineTo lineTo = new LineTo(698, 710);

            path.getElements().addAll(moveTo, lineTo);

            PathTransition pt = new PathTransition();
            pt.setDuration(Duration.millis(400 + getRandom(1000)));
            pt.setNode(c1);
            pt.setPath(path);
            parallelTransition.getChildren().add(pt);
        }

        //root.getChildren().add(root3);
        SequentialTransition sq = new SequentialTransition(parallelTransition);
        sq.play();

        ball.setFill(arr.get(getRandom(4)));
        EventHandler<ActionEvent> event1 = actionEvent -> {
            for (int i=0; i<1000; i++)
            {
                root.getChildren().remove(smallballs.get(i));
            }
        };

        sq.setOnFinished(event1);
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
        mediaPlayer.setAutoPlay(Main.sound);
    }

    public void scroll()
    {
        if(ball.getLayY()<375) {
            for (int i = 0; i < root_list.size(); i++) {
                double dey = root_list.get(i).getLayoutY();
                root_list.get(i).setLayoutY(dey + 2);
            }
        }
    }

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
            this.setupGame();
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
                lastUpdate = now;
            }
        };

        scene2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.Q) {
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
                try {
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
                t.stop();
                root.setEffect(new GaussianBlur());

                VBox pauseRoot = new VBox(40);
                pauseRoot.setId("menu");
                pauseRoot.setAlignment(Pos.CENTER);
                pauseRoot.setPadding(new Insets(20));
                pauseRoot.setEffect(new DropShadow(20, Color.BLACK));
                pauseRoot.setFillWidth(true);

                String  style= getClass().getResource("styles.css").toExternalForm();
                pauseRoot.getStylesheets().add(style);

                Label paused = new Label("Paused");
                pauseRoot.getChildren().add(paused);
                paused.setId("paused");
                paused.setEffect(new DropShadow(20,Color.BLACK));

                Button resume = new Button("Resume");
                pauseRoot.getChildren().add(resume);
                resume.setId("resume");
                resume.setEffect(new DropShadow(20, Color.BLACK));

                Button exit=new Button("Exit");
                pauseRoot.getChildren().add(exit);
                exit.setId("exit");
                exit.setEffect(new DropShadow(20, Color.BLACK));

                Button save_game=new Button("Save and exit");
                pauseRoot.getChildren().add(save_game);
                save_game.setId("save");
                save_game.setEffect(new DropShadow(20, Color.BLACK));

                Button restart = new Button("Restart ");
                pauseRoot.getChildren().add(restart);
                restart.setId("resume");
                restart.setEffect(new DropShadow(20, Color.BLACK));


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
                    try {
                        Main.user.incrementTotalScore(score);
                        if (Main.user.getHighestScore() < score)
                            Main.user.setHighestScore(score);
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
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
                        Main.user.incrementTotalScore(score);
                        if(Main.user.getHighestScore() < score)
                            Main.user.setHighestScore(score);
                        new MainPage();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });

                restart.setOnAction(event -> {
                    root.setEffect(null);
                    try {
                        Main.user.incrementTotalScore(score);
                        if(Main.user.getHighestScore() < score)
                            Main.user.setHighestScore(score);
                        //System.out.println("restart");
                        popupStage.hide();
                        new Game();
                    }
                    catch(Exception ef)
                    {
                        ef.printStackTrace();
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

            for(int i=0;i<this.obstacles.size();i++)
            {
                double temp = this.obstacles.get(i).y+this.root_list.get(this.root_list.indexOf(this.obstacles.get(i).getRoot())).getLayoutY();
                this.obstacles.get(i).y = temp;
                // System.out.println(this.obstacles.get(i).y+" "+this.obstacles.get(i)+" saving ");
            }

            for(int i=0;i<this.stars.size();i++)
            {
                double temp = this.stars.get(i).getY()+this.root_list.get(this.root_list.indexOf(this.stars.get(i).getRoot())).getLayoutY();
                this.stars.get(i).setY(temp);
                // System.out.println(this.stars.get(i).y+" "+this.stars.get(i).getClass());
            }

            for(int i=0;i<this.colorSwitches.size();i++)
            {
                double temp = this.colorSwitches.get(i).getLayoutY()+this.root_list.get(this.root_list.indexOf(this.colorSwitches.get(i).getRoot())).getLayoutY();
                this.colorSwitches.get(i).setLayoutY(temp);
                // System.out.println(this.colorSwitches.get(i).getLayoutY()+" "+this.colorSwitches.get(i).getClass());
            }
            out.writeObject(this);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            out.close();
        }
    }
}