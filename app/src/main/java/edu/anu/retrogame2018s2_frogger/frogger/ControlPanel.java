package edu.anu.retrogame2018s2_frogger.frogger;

import android.transition.Scene;

public class ControlPanel {
    private Scene scene;
    private int x;
    private int y;

    public ControlPanel(Scene scene, int x, int y) {
        this.scene = scene;
        this.x = x;
        this.y = y;
    }

    public void draw(FrogCanvas frogCanvas) {

    }

    private static Path getTriangle(int[] path,int a,Direction direction) {
        return null;
    }

    public void onTouch(float x,float y,boolean b){

    }

    public double calculateAngle(double x1,double y1,double x2,double y2){
        return 0;
    }

    enum Direction{
        SOUTH,WEST,NORTH,EAST
    }
}
