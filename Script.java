import java.io.*;
import java.util.*;
public class Script
{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        // ObjectOutputStream out = null;
        // try
        // {
        //     out = new ObjectOutputStream(new FileOutputStream("highScore.t1xt"));
        //     Integer score = 0;
        //     out.writeObject(score);   
        //     out = new ObjectOutputStream(new FileOutputStream("totalScore.t1xt"));
        //     out.writeObject(score);   
        // }
        // finally
        // {
        //     out.close();
        // }
        ObjectInputStream in = null;
        try{
            in  = new ObjectInputStream(new FileInputStream("highScore.t1xt"));
            Integer a = (Integer)in.readObject();
            System.out.println(a);
        }
        finally{
            in.close();
        }
    }
}