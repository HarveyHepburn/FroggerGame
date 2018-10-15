package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import edu.anu.retrogame2018s2_frogger.frogger.Frog;

public interface MoveAlong {
    void moveAlong(Spirit spirit);
    boolean Collision(Spirit spirit);
}
