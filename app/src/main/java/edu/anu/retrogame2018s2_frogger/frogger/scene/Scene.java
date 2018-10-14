package edu.anu.retrogame2018s2_frogger.frogger.scene;


public interface Scene extends Drawable{
    void onEnterScene(FrogCanvas frogCanvas);
    void onFinishScene(FrogCanvas frogCanvas);
    void sceneOver(DialogInformation dialogInformation);
    void move(ControlPanel.Direction direction);
    String onBackPressed();
    boolean isMoveble(int x,int y);
    String onTouch(float x, float y, boolean isDown);
    boolean isActive();
    GameSetting getGameSetting();
}
