package sample;
import java.io.Serializable;
import java.util.*;
public class User implements Serializable {
    long highestScore = 0;
    String name;
    public User(String name)
    {
        this.name = name;
    }
}
