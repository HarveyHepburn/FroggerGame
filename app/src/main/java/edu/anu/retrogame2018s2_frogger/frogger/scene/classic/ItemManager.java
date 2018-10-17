package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

public interface ItemManager {
    ActiveItem getAvailableItem();

    ActiveItem getNewItem(MovingParameters movingParameters);

    void addToPool(ActiveItem activeItem);
}