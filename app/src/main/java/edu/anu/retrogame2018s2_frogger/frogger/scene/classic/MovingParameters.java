package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;
/*
    Author: Danny Feng
 */
public interface MovingParameters {

    int getSpeed();

    boolean getDir();

    int getY();

    int calX(int width);
}
