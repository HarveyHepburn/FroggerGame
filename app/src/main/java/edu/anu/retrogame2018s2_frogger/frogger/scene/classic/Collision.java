package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

public abstract class Collision {
    public boolean collision(Spirit spirit, int x, int y,int height,int width) {
        if (spirit.getY() < y + height && spirit.getY() >= y) {
            if (spirit.getX() + spirit.getRadius() >= x && spirit.getX() - spirit.getRadius() <= x + width) {
                return true;
            }
        }
        return false;
    }
}
