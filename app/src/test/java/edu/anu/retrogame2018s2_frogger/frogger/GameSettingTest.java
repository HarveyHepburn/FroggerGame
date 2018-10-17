package edu.anu.retrogame2018s2_frogger.frogger;

import org.junit.Test;

import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
import edu.anu.retrogame2018s2_frogger.frogger.scene.welcome.WelcomeScene;
import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;

import static org.junit.Assert.*;

public class GameSettingTest {
    @Test
    public void screenWidthAndHeightTest(){
        GameSetting gameSetting=new GameSetting(100,200);
        assertEquals(100,gameSetting.getWidth());
        assertEquals(200,gameSetting.getHeight());
    }

    @Test
    public void frogResettingTest() {
        GameSetting gameSetting = new GameSetting(100, 200);
        SoundControl s = new SoundControl() {
            @Override
            public void playMusic(String musicName) {

            }

            @Override
            public void playSound(String musicName) {

            }

            @Override
            public void stopMusic() {

            }

            @Override
            public void stopSound() {

            }

            @Override
            public boolean isSoundPlaying() {
                return false;
            }
        };
        gameSetting.setSoundControl(s);
        Scene scene = new WelcomeScene(gameSetting);
        Frog frog = new Frog(scene);
        gameSetting.setFrog(frog);
        assertEquals(frog, gameSetting.getFrog());
        Frog frog2 = new Frog(scene);
        gameSetting.setFrog(frog2);
        assertEquals(frog2, gameSetting.getFrog());
    }
}