package sample;
import java.io.Serializable;
import java.util.*;
import java.io.*;
public class User implements Serializable {
    private long highestScore = 0;
    private long totalScore=0;
    private String name;

    public User(String name)
    {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public long getHighestScore()
    {
        return this.highestScore;
    }

    public long getTotalScore()
    {
        return this.totalScore;
    }

    public void incrementTotalScore(long score) throws IOException
    {
        this.totalScore+=score;
        ObjectOutputStream out = null;
        try
        {
            out = new ObjectOutputStream(new FileOutputStream("totalScore.t1xt"));
            out.writeObject(this.totalScore);
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

    public void setHighestScore(long score) throws IOException
    {
        this.highestScore=score;
        ObjectOutputStream out = null;
        try
        {
            out = new ObjectOutputStream(new FileOutputStream("highScore.t1xt"));
            out.writeObject(this.highestScore);
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

    public void initScores() throws IOException
    {
        ObjectInputStream in = null;
        try{
            in  = new ObjectInputStream(new FileInputStream("highScore.t1xt"));
            this.highestScore = (Long)in.readObject();
            in  = new ObjectInputStream(new FileInputStream("totalScore.t1xt"));
            this.totalScore = (Long)in.readObject();
//            System.out.println(this.highestScore+" "+this.totalScore);
        }
        catch (Exception e)
        {
//            e.printStackTrace();
        }
        finally{
            in.close();
        }
    }
}