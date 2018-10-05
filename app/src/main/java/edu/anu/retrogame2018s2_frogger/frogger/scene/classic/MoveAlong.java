package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.Frog;

public interface MoveAlong {
    void moveAlong(Frog frog);
    boolean collision(Frog frog);
}
