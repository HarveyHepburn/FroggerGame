package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Lane extends ArrayList<ActiveItem> implements MovingParameters, Drawable {
    int speed;
    int gap;
    ItemManager itemManager;
    boolean direction;//true is to right;false is to left
    int y;

    Scene scene;

    public Lane(int speed, int gap, ItemManager itemManager, boolean direction, int y, Scene scene) {
        this.speed = speed;
        this.gap = gap;
        this.itemManager = itemManager;
        this.direction = direction;
        this.y = y;
        this.scene = scene;
    }

    @Override

    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean getDir() {
        return direction;
    }

    @Override
    public int getY() {
        return y;
    }

    // to be done
    @Override
    public int calX(int x) {
        if (direction) {
            return -1;
        } else {
            return 0;
        }

    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        for (ActiveItem item : this) {
            item.draw(frogCanvas);
        }
    }

    public ActiveItem getNewItem() {
        ActiveItem activeItem = itemManager.getAvailableItem();
        if (activeItem == null) {
            return itemManager.generateNewItem(this);
        } else activeItem.resetItem(this);
        return activeItem;
    }

    @Override
    public void step() {
        if (this.size() == 0) {
            this.add(getNewItem());
        } else {
            if (direction) {
//                if (this.get(0).getX() > scnene.gameSetting) {
//                    this.remove(this.get(0));
//                }
            } else {
                if (this.get(0).getX() < 0) {
                    this.remove(this.get(0));
                }
            }
            if (direction) {
                if (this.get(this.size() - 1).getX() > gap) {
                    this.add(getNewItem());
                }
            } else {
                // if(this.get(this.size() - 1).getX()-scnene.gameSetting > gap){}
            }

        }
    }
}
