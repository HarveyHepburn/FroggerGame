package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;


import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Cars extends Items implements ItemManager {
    private Scene scene;

    public Cars(Scene scene) {
        this.scene = scene;
        this.add(new Lane(false, 4, 300, this, 900, scene));
        this.add(new Lane(true, 6, 500, this, 800, scene));
        this.add(new Lane(false, 3, 350, this, 700, scene));
        this.add(new Lane(true, 2, 300, this, 600, scene));
    }

    @Override
    public ActiveItem getNewItem(MovingParameters movingParameters) {
        return new Car(movingParameters, scene);
    }
}
