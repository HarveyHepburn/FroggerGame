package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

public interface MovingParameters {

    int getSpeed();

    boolean getDir();

    int getY();

    int calX(int x);
}
