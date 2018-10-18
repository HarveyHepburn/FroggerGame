package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

//Item means game elements like car, log
public interface ItemManager {
    ActiveItem getAvailableItem();

    ActiveItem getNewItem(MovingParameters movingParameters);

    void addToPool(ActiveItem activeItem);
}