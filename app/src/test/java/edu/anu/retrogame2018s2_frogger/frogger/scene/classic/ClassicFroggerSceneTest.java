package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import org.junit.Test;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.FroggerGame;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.Path;
import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.scene.ranking.DBManager;
import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;

import static org.junit.Assert.*;

public class ClassicFroggerSceneTest {

    GameSetting gameSetting;
    FroggerGame froggerGame;

    public ClassicFroggerSceneTest() {
        froggerGame = new FroggerGame(2500, 1000, new SoundControl() {
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

            @Override
            public boolean isMusicPlaying() {
                return false;
            }
        }, new DBManager() {
            @Override
            public void addData(RecordInfo playerInfo) {

            }

            @Override
            public ArrayList<RecordInfo> getData() {
                return null;
            }

            @Override
            public ArrayList<String> getPlayer() {
                return null;
            }

            @Override
            public Boolean playerExist(String name) {
                return null;
            }
        });
        gameSetting = froggerGame.getGameSetting();
        gameSetting.put("holeNumber",3);
        this.classicFroggerScene = new ClassicFroggerScene(gameSetting);


    }

    ClassicFroggerScene classicFroggerScene;

    @Test
    public void getDialog() {
        assertEquals(null, classicFroggerScene.getDialog());
    }


    @Test
    public void getGameSetting() {
        assertEquals(gameSetting, classicFroggerScene.getGameSetting());
    }

    @Test
    public void move() {
        classicFroggerScene.getGameSetting().setSoundControl(new SoundControl() {
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

            @Override
            public boolean isMusicPlaying() {
                return false;
            }
        });
        classicFroggerScene.move(Direction.SOUTH);
        int oldPos = classicFroggerScene.getGameSetting().getFrog().getY();
        classicFroggerScene.step();
        assertEquals(oldPos - 6, classicFroggerScene.getGameSetting().getFrog().getY());


        classicFroggerScene.move(Direction.EAST);
        oldPos = classicFroggerScene.getGameSetting().getFrog().getX();
        classicFroggerScene.step();
        assertEquals(oldPos + 6, classicFroggerScene.getGameSetting().getFrog().getX());

        classicFroggerScene.move(Direction.WEST);
        oldPos = classicFroggerScene.getGameSetting().getFrog().getX();
        classicFroggerScene.step();
        assertEquals(oldPos - 6, classicFroggerScene.getGameSetting().getFrog().getX());


        classicFroggerScene.move(Direction.NORTH);
        oldPos = classicFroggerScene.getGameSetting().getFrog().getY();
        classicFroggerScene.step();
        assertEquals(oldPos + 6, classicFroggerScene.getGameSetting().getFrog().getY());

    }

    @Test
    public void onBackPressed() {
        assertEquals(null, classicFroggerScene.onBackPressed());
        classicFroggerScene.onTouch(gameSetting.getWidth() / 2, gameSetting.getHeight() / 2, true);
    }

    @Test
    public void isMoveble() {
        assertFalse(classicFroggerScene.isMoveble(10, 10));
        assertTrue(classicFroggerScene.isMoveble(10, 300));
    }

    @Test
    public void onTouch() {
        classicFroggerScene.sceneOver(new DialogInformation("end"));
        assertFalse(classicFroggerScene.isActive());
        assertEquals("levels", classicFroggerScene.onTouch(gameSetting.getWidth() / 2, gameSetting.getHeight() / 2, true));

    }

    @Test
    public void isActive() {
        assertEquals(null, classicFroggerScene.onBackPressed());
        assertFalse(classicFroggerScene.isActive());
        classicFroggerScene.onTouch(gameSetting.getWidth() / 2, gameSetting.getHeight() / 2, true);
        assertTrue(classicFroggerScene.isActive());
    }


    @Test
    public void sceneOver() {
//        classicFroggerScene.sceneOver(new DialogInformation("info"));
//        assertEquals(false,classicFroggerScene.isActive());
//        assertNotEquals(null,classicFroggerScene.getDialog());
    }
}