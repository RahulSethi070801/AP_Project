package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

class StarRace
{
    Group root, root1;
    double y;
    public static boolean isCollide(Circle x, Shape y)
    {
        Shape intersect = Shape.intersect(x,y);
        boolean b = false;
        if (intersect.getBoundsInLocal().getWidth() != -1)
        {
            b = true;
        }
        return b;
    }
    public boolean blast(Circle ball)
    {
        for(int i=0;i<root1.getChildren().size();i++)
        {

            if (isCollide(ball, (Shape)root1.getChildren().get(i)))
            {
                return true;
            }
        }
        return false;
    }
    public void show(double x1, double y1) throws FileNotFoundException
    {
        String localDir = System.getProperty("user.dir");
        InputStream stream3 = new FileInputStream(localDir+"\\Star1.png");
        Image image3 = new Image(stream3);
        ImageView imageView31 = new ImageView();
        imageView31.setImage(image3);
        imageView31.setX(x1);
        imageView31.setY(y1);
        imageView31.setFitWidth(50);
        imageView31.setPreserveRatio(true);
//        ImageView imageView32 = new ImageView();
//        imageView32.setImage(image3);
//        imageView32.setX(x2);
//        imageView32.setY(y2);
//        imageView32.setFitWidth(50);
//        imageView32.setPreserveRatio(true);

        Circle c  = new Circle(x1+25, y1+20, 15);
        //Circle c1  = new Circle(x2+25, y2+25, 15);
        //c1.setFill(Color.TRANSPARENT);
        c.setFill(Color.TRANSPARENT);
        root = new Group();

        root1 = new Group();
        root1.getChildren().add(c);

        root.getChildren().addAll(imageView31, root1);

//        this.y = y;
//        root.setTranslateY(y);
//        return root;
    }
    public Group getRoot()
    {
        return root;
    }

    public Group getRoot1()
    {
        return root1;
    }

    public void setLayoutY(double y)
    {
        this.y = y;
        root.setLayoutY(y);
    }
    public double getLayoutY()
    {
        this.y = this.root.getLayoutY();
        return root.getLayoutY();
    }
}
