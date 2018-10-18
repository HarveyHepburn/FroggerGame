package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import java.util.ArrayList;
import java.util.List;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;

//Item means game elements like car, log
public class Items extends ArrayList<Lane> implements Drawable {
    private List<ActiveItem> itemPool = new ArrayList<>();
    private static int MAX_POOL_SIZE = 30;

    public ActiveItem getAvailableItem() {
        if (this.itemPool.size() > 0) {
            return itemPool.remove(0);
        }
        return null;
    }

    public void addToPool(ActiveItem activeItem) {
        if (this.itemPool.size() < MAX_POOL_SIZE) {
            this.itemPool.add(activeItem);
        }
    }

    public void draw(FrogCanvas frogCanvas) {
        for (Lane carLane : this) {
            carLane.draw(frogCanvas);
        }
    }

    public void step() {
        for (Lane lane : this) {
            lane.step();
        }
    }
}