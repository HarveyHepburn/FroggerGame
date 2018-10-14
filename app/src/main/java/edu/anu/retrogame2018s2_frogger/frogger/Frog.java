package edu.anu.retrogame2018s2_frogger.frogger;


import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.classic.Log;

public class Frog {
    public Frog(Scene scene) {
        this.x = scene.getGameSetting().getWidth() / 2;
        this.y = scene.getGameSetting().getHeight() - radius;
        frogPaint.setColor("#1b5e20");
        this.scene = scene;
    }

    public void resetFrog() {
        this.x = scene.getGameSetting().getWidth() / 2;
        this.y = scene.getGameSetting().getHeight() - radius;
    }

    int y, x;
    private Scene scene;
    private int radius = 80;
    private Log log = null;
    private ControlPanel.Direction direction = null;
    private FrogPaint frogPaint = new FrogPaint();

    private int FrogStatus=0;
    private int currentStatusTimeLeft=5;

    public void draw(FrogCanvas frogCanvas) {
        switch (FrogStatus){
            case 0:
                frogCanvas.drawImage("frog_static",x-radius/2,y-radius/2,x+radius/2,y+radius/2,frogPaint);
                break;
            case 1:
                frogCanvas.drawImage("frog_jump_1",x-radius/2,y-radius/2,x+radius/2,y+radius/2,frogPaint);
                break;
            case 2:
                frogCanvas.drawImage("frog_jump_2",x-radius/2,y-radius/2,x+radius/2,y+radius/2,frogPaint);
                break;
            case 3:
                frogCanvas.drawImage("frog_jump_3",x-radius/2,y-radius/2,x+radius/2,y+radius/2,frogPaint);
                break;
        }

    }

    public void step() {

        if (this.direction != null) {
            if (direction == ControlPanel.Direction.EAST) {
                if (this.scene.isMoveble(x + 6, this.y))
                    this.x += 6;
            } else if (direction == ControlPanel.Direction.SOUTH) {
                if (this.scene.isMoveble(x, this.y - 6))
                    this.y -= 6;
            } else if (direction == ControlPanel.Direction.NORTH) {
                this.y += 6;
            } else if (direction == ControlPanel.Direction.WEST) {
                if (this.scene.isMoveble(x - 6, this.y))
                    this.x -= 6;
            }
        }
        if (this.log != null) {
            if (!this.log.Collision(this)) {
                this.log = null;
                return;
            }
            log.moveAlong(this);
        }

        this.currentStatusTimeLeft-=1;
        if(currentStatusTimeLeft<=0){
            this.FrogStatus=(FrogStatus+1)%4;
            currentStatusTimeLeft=5;
        }
    }

    public Log getLog() {
        return log;
    }

    public void move(ControlPanel.Direction direction) {
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void logOn(Log log) {
        this.log = log;
    }
}
