package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

/**
 * @Author: Yu Yang (Harvey), Boyuan Zheng(Joe)
 */
public interface MoveAlong {
    void moveAlong(Spirit spirit);

    boolean Collision(Spirit spirit);
}
