package edu.anu.retrogame2018s2_frogger.frogger.animation;
/*
    Author: Yang Yu
 */
public class Animation {
    float speed;
    float max;
    float min;
    boolean increasing = true;
    float current = 0;

    public Animation(float speed, float max, float min) {
        this.speed = speed;
        this.max = max;
        this.min = min;
    }

    public void step() {
        if (this.increasing) {
            this.current += speed;
            if (this.current >= this.max) {
                this.current = max;
                this.increasing = false;
            }
        } else {
            this.current -= speed;
            if (this.current <= this.min) {
                this.current = min;
                this.increasing = true;
            }
        }
    }
}
