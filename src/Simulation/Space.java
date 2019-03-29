package Simulation;

public class Space {

    private double x;
    private double y;
    private double height;
    private double widht;
    private String name;

    public Space(String name, double x, double y, double widht, double height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.widht = widht;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidht() {
        return widht;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Space{" + "x=" + x + ", y=" + y + ", height=" + height + ", widht=" + widht + ", name='" + name + '\'' + '}';
    }
}
