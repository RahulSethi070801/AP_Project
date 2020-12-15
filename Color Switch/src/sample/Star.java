package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

public class Star implements Serializable {

    transient Group root;
    double y;
    public Group  show(double x, double y) throws FileNotFoundException
    {
        String localDir = System.getProperty("user.dir");
        InputStream stream3 = new FileInputStream(localDir+"\\Star1.png");
        Image image3 = new Image(stream3);
        ImageView imageView3 = new ImageView();
        imageView3.setImage(image3);
        imageView3.setX(x);
        imageView3.setY(y);
        imageView3.setFitWidth(50);
        imageView3.setPreserveRatio(true);
        root = new Group(imageView3);
        this.y = y;
//        root.setTranslateY(y);
        return root;
    }
    public Group getRoot()
    {
        return root;
    }

    public void setLayoutY(double y)
    {
        this.y=y;
        root.setLayoutY(y);
    }
    public double getLayoutY()
    {
        this.y = root.getLayoutY();
        return root.getLayoutY();
    }
}
