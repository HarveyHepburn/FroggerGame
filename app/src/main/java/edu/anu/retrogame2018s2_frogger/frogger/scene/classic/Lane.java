package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

import java.util.ArrayList;
import java.util.Iterator;

public class Lane extends ArrayList<ActiveItem> implements MovingParameters,Drawable {
    private int speed;
    private int gap;
    private ItemManager itemManager;
    private boolean dir;
    private int y;
    private Scene scene;

    Lane(boolean dir, int speed, int gap, ItemManager itemManager, int y,Scene scene) {
        this.speed = speed;
        this.gap = gap;
        this.itemManager = itemManager;
        this.y = y;
        this.dir=dir;
        this.scene=scene;
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        for (ActiveItem activeItem : this) {
            activeItem.draw(frogCanvas);
        }
    }

    private ActiveItem getNewItem() {
        ActiveItem activeItem = itemManager.getAvailableItem();
        if (activeItem != null) {
            activeItem.resetItem(this);
        } else {
            activeItem = itemManager.getNewItem(this);
        }
        return activeItem;
    }

    @Override
    public void step() {
        Iterator<ActiveItem> iter = this.iterator();
        int oldSize=this.size();
        while (iter.hasNext()) {
            ActiveItem activeItem = iter.next();
            if (dir && activeItem.getX() > scene.getGameSetting().getWidth()) {
                iter.remove();
                itemManager.addToPool(activeItem);
                continue;
            }
            if (!dir && activeItem.getX() + activeItem.getWidth() < 0) {
                iter.remove();
                itemManager.addToPool(activeItem);
                continue;
            }
            activeItem.step();
            if (activeItem.outOfMap()) {
                iter.remove();
                itemManager.addToPool(activeItem);
                continue;
            }
            if (activeItem.activity(scene.getGameSetting().getFrog())) {
                return;
            }
        }

        if (dir) {
            if (this.size() > 0) {
                if (this.get(this.size() - 1).getX() > gap) {
                    this.add(getNewItem());
                }
            } else {
                this.add(getNewItem());
            }

        } else {
            if (this.size() > 0) {
                if (this.get(this.size() - 1).getX() < scene.getGameSetting().getWidth() - gap) {
                    this.add(getNewItem());
                }
            }else {
                this.add(getNewItem());
            }
        }
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean getDir() {
        return dir;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int calX(int width) {
        return dir ? (-1*width) : scene.getGameSetting().getWidth() + width;
    }
}
