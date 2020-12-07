package sample;

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
    User user;
    long score = 0;
    long difficulty = 0;
    String name;
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
    public void show() throws FileNotFoundException
    {

        Ball ball = new Ball(); // ball is the object of Ball Class
        Circle ball_c = ball.show();
        Group root_ball = ball.getRoot();
        stars = new ArrayList<Star>();
        colorSwitches = new ArrayList<ColorSwitch>();

        //Circle c = ball.getRoot().getChildren().get(0);

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
//        HashMap<String, Obstacle> hash = new HashMap<String, Obstacle>();
//        hash.put("Ring", new Ring());
        ArrayList<Group> root_list = new ArrayList<Group>();
        long y=0;
//        Obstacle Ccircle = new ConcentricCircles();
//        Ccircle.show(y);
//        y-=500;
//        obstacles.add(Ccircle);
//        root.getChildren().add(Ccircle.getRoot());
//        root_list.add(Ccircle.getRoot());
        for(int i=0;i<100;i++)
        {
            int ind = rand.nextInt(8);
//            int ind = 0;
            Obstacle o = new Obstacle();
            Star star = new Star();
            ColorSwitch colorswitch = new ColorSwitch();
            if(tempO[ind].equals("Ring"))
            {
                o = new Ring();
                star.show((double)700, (double)y);
//                star = new Star();
            }
            if(tempO[ind].equals("Square"))
            {
                o = new Square();
                star.show((double)700, (double)y);

            }
            if(tempO[ind].equals("HorizontalCircles"))
            {
                o = new HorizontalCircles();
                star.show((double)700, (double)y);

            }
            if(tempO[ind].equals("Concentric"))
            {
                o = new ConcentricCircles();
                star.show((double)700, (double)y);

            }
            if(tempO[ind].equals("Triangle"))
            {
                o = new Triangle();
                star.show((double)700, (double)y);

            }
            if(tempO[ind].equals("Lines"))
            {
                o = new HorizontalLine();
            }
            if(tempO[ind].equals("2Plus"))
            {
                o = new TwoPlus();
                star.show((double)700, (double)y);

            }
            if(tempO[ind].equals("Plus"))
            {
                o = new Plus();
                star.show((double)700, (double)y);
            }
            o.show(y);
            y-=500;
            obstacles.add(o);
            Group root_square = o.getRoot();
            root.getChildren().add(root_square);
            root_list.add(root_square);
        }

        // Score count
        Text text1 = new Text();
        text1.setText(String.valueOf(score));
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        text1.setFill(Color.WHITE);
        text1.setStrokeWidth(5);
        text1.setX(130);
        text1.setY(100);
        Group root_text = new Group(text1);
        root.getChildren().add(root_text);

        String localDir = System.getProperty("user.dir");
        // collectable star
        Star star = new Star();
        Group root6 = star.show(675.0, 375.0);

        ColorSwitch c1 = new ColorSwitch();
        Group root5 = c1.show(0);
        root.getChildren().add(root5);

        // timeline for ball
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {

                    double dx = 7; //Step on x or velocity
                    double dy = 7; //Step on y

                    @Override
                    public void handle(ActionEvent t) {

                        ball.setLayoutY(dy);

                        double curr = ball.getLayY();

                        if (obstacles.get(0).getY() > curr + 800)



                        obstacles.get(0).blast(ball_c);
                        obstacles.get(1).blast(ball_c);
                        obstacles.get(2).blast(ball_c);
                        obstacles.get(3).blast(ball_c);
                        obstacles.get(4).blast(ball_c);
                        obstacles.get(5).blast(ball_c);
                        obstacles.get(6).blast(ball_c);


                        if (root.getChildren().contains(root5) && isCollide(ball, root5))
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
                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 2)
                                {
                                    ball.setFill(Color.rgb(50, 219, 240));
                                    ball.setColor(Color.rgb(50, 219, 240));
                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 3)
                                {
                                    ball.setFill(Color.rgb(255, 1, 129));
                                    ball.setColor(Color.rgb(255, 1, 129));
                                    root.getChildren().remove(root5);
                                    break;
                                }
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

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10),
                new EventHandler<ActionEvent>() {
                    double dy = -10; //Step on y
                    @Override
                    public void handle(ActionEvent t) {

                        ball.setLayoutY( dy);
                        ball.getLayY();
                        if(ball.getLayY()<500) {
                            for (int i = 0; i < 100; i++) {
                                double dey = root_list.get(i).getLayoutY();
                                root_list.get(i).setLayoutY(dey - dy);
                            }
                        }
                        Bounds bounds = root.getBoundsInLocal();
                        obstacles.get(0).blast(ball_c);

                        if (root.getChildren().contains(root5) && isCollide(ball, root5))
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
                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 2)
                                {
                                    ball.setFill(Color.rgb(50, 219, 240));
                                    root.getChildren().remove(root5);
                                    break;
                                }
                                if (getRandom(4) == 3)
                                {
                                    ball.setFill(Color.rgb(255, 1, 129));
                                    root.getChildren().remove(root5);
                                    break;
                                }
                            }
                        }
                        if (root.getChildren().contains(root6) && isCollide(ball, root6))
                        {
                            //System.out.println("touch");
                            root.getChildren().remove(root6);
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

        // event handler for user control of ball
        scene2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                //System.out.println("A key was pressed");
                timeline.play();
                timeline1.play();
            }
        });

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
                    timeline1.pause();
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


        root.getChildren().add(root6);


        root.getChildren().add(root_ball);

    }

}
