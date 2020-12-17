package sample;
import java.io.Serializable;
import java.util.*;
public class User implements Serializable {
    private long highestScore = 0;
    private long totalScore=0;
    private String name;
    public User(String name)
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
    public void incrementTotalScore(long score)
    {
        this.totalScore+=score;
    }
    public void setHighestScore(long score)
    {
        this.highestScore=score;
    }
}