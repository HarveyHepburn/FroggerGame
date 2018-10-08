package edu.anu.retrogame2018s2_frogger.frogger.scene;

import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.SceneEndInformation;

public interface Scene extends Drawable {
    void onEnterScene(FrogCanvas frogCanvas);

    void onFinishScene(FrogCanvas frogCanvas);

    void sceneOver(SceneEndInformation sceneEndInformation);

    void move(Direction direction);

    boolean isMoveble(int x, int y);//whether move is legel

    Integer onTouch(float x, float y, boolean b);//b: is click down/up

    boolean isActive();//whether scence is in active status

    GameSetting getGameSetting();
}