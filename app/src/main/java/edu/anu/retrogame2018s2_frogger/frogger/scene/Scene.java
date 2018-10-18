package edu.anu.retrogame2018s2_frogger.frogger.scene;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;

/**
 * @Author: Yu Yang (Harvey), Boyuan Zheng(Joe)
 */
public interface Scene extends Drawable {
    void onEnterScene(FrogCanvas frogCanvas);

    void onFinishScene(FrogCanvas frogCanvas);

    void sceneOver(DialogInformation dialogInformation);

    void move(Direction direction);

    String onBackPressed();

    boolean isMoveble(int x, int y);

    String onTouch(float x, float y, boolean isDown);

    boolean isActive();

    GameSetting getGameSetting();
}
