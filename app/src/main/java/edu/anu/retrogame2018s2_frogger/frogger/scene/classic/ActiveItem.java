package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
/*
    Author: Yang Yu
 */
interface ActiveItem extends Drawable {
    int getX();
    int getWidth();
    boolean outOfMap();
    boolean activity(Frog frog);
    void resetItem(MovingParameters movingParameters);
}