package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

public interface MovingParameters {
    boolean direction = false;
    float speed = 0;
    float size = 0;

    void changeDirection();

    void speedUp();

    void speedDown();
}
