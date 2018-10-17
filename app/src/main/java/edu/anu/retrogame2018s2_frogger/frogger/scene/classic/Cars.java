package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;


import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class Cars extends Items implements ItemManager {
    private Scene scene;

    public Cars(Scene scene) {
        this.scene = scene;
        int roadHeight=scene.getGameSetting().get("roadBottom")-scene.getGameSetting().get("roadTop");
        int verticalGap=(int)(roadHeight*0.025);
        int carHeight=((scene.getGameSetting().get("roadBottom")-scene.getGameSetting().get("roadTop"))/5);

        int firstLane=scene.getGameSetting().get("roadTop")+verticalGap;
        int secondLane=firstLane+verticalGap*2+carHeight;
        int thirdLane=secondLane+verticalGap*3+carHeight;
        int forthLane=thirdLane+verticalGap*2+carHeight;


        this.add(new Lane(false, 4, carHeight*4, this, firstLane, scene));
        this.add(new Lane(true, 6, carHeight*6, this, secondLane, scene));
        this.add(new Lane(false, 3, carHeight*3, this, thirdLane, scene));
        this.add(new Lane(true, 2, carHeight*5, this, forthLane, scene));
    }

    @Override
    public ActiveItem getNewItem(MovingParameters movingParameters) {
        return new Car(movingParameters, scene);
    }
}
