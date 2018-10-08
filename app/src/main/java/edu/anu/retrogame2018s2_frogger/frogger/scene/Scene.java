package edu.anu.retrogame2018s2_frogger.frogger.scene;

import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.SceneEndInformation;

public interface Scene extends Drawable {
    public void onEnterScene(FrogCanvas frogCanvas);
    public void onFinishScene(FrogCanvas frogCanvas);
    public void sceneOver(SceneEndInformation sceneEndInformation);
    public void move(Direction direction);
    public boolean isMoveble(int x,int y);//whether move is legel
    public Integer onTouch(float x,float y,boolean b);//b: is click down/up
    public boolean isActive();//whether scence is in active status
    //public GameSetting getGameSetting();
}
