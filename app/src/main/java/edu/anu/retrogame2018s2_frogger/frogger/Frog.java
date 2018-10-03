package edu.anu.retrogame2018s2_frogger.frogger;

public class Frog {
//    public Frog(Scene scene) {
//    }

    public void resetFrog() {
    }

    int y, x;
//    private Scene scene;
    private int radius = 50;
//    private Log log = null;
//    private ControlPanel.Direction direction = null;
    private FrogPaint frogPaint = new FrogPaint();

    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawCircle(x, y, radius, frogPaint);
    }

    public void step() {


    }

//    public Log getLog() {
//        return log;
//    }

//    public void move(ControlPanel.Direction direction) {
//        this.direction = direction;
//    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

//    public void logOn(Log log) {
//        this.log = log;
//    }
}