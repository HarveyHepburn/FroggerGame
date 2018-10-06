package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

public interface ItemManager {
    public ActiveItem getActiveItem();
    public ActiveItem generateNewItem(MovingParameters movingParameters);
    public void addToPool(ActiveItem activeItem);
}
