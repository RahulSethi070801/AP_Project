package sample;

public class Obstacle
{
    protected double speed;
    protected String colors[] = { "Red", "Blue", "Pink", "Yellow"};
    protected long x;
    protected long y;
    protected double thickness;

    public void move()
    {

    }

    public double getSpeed()
    {
        return this.speed;
    }

    public double getThickness() {
        return thickness;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setY(long y) {
        this.y = y;
    }

    public void setX(long x) {
        this.x = x;
    }
}

