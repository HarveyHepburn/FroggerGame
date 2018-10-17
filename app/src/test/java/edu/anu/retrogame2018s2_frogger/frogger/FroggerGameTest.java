package edu.anu.retrogame2018s2_frogger.frogger;

import org.junit.Test;

import edu.anu.retrogame2018s2_frogger.frogger.scene.level.LevelButton;
import edu.anu.retrogame2018s2_frogger.frogger.scene.welcome.WelcomeScene;
import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;

import static org.junit.Assert.*;

public class FroggerGameTest {


    @Test
    public void initTest() {
        FroggerGame froggerGame = new FroggerGame(2500, 1000, new SoundControl() {
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
        });
        assertTrue(froggerGame.currentScene instanceof WelcomeScene);
    }

    @Test
    public void getGameSetting() {
        FroggerGame froggerGame = new FroggerGame(2500, 1000, new SoundControl() {
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
        });
        assertTrue(froggerGame.getGameSetting() instanceof GameSetting);
        assertEquals(null, froggerGame.getGameSetting().getFrog());
        assertEquals(1000, froggerGame.getGameSetting().getHeight());
        assertEquals(2500, froggerGame.getGameSetting().getWidth());
        assertEquals(new Integer(5), froggerGame.getGameSetting().get("levels"));
    }
}