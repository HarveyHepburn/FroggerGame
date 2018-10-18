package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import org.junit.Test;

import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;
import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;

import static org.junit.Assert.*;

public class LaneTest {

    @Test
    public void getSpeed() {
        GameSetting gameSetting = new GameSetting(500, 500);
        gameSetting.put("holeNumber",3);
        gameSetting.setSoundControl(new SoundControl() {
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
        Scene scene = new ClassicFroggerScene(gameSetting);
        Lane lane = new Lane(true, 50, 100, new Cars(scene), 200, scene);

        assertEquals(50, lane.getSpeed());
    }

    @Test
    public void getDir() {
        GameSetting gameSetting = new GameSetting(500, 500);
        gameSetting.put("holeNumber",3);
        gameSetting.setSoundControl(new SoundControl() {
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

        Scene scene = new ClassicFroggerScene(gameSetting);
        Lane lane = new Lane(true, 50, 100, new Cars(scene), 200, scene);

        assertEquals(true, lane.getDir());
    }

    @Test
    public void getY() {
        GameSetting gameSetting = new GameSetting(500, 500);
        gameSetting.put("holeNumber",3);
        gameSetting.setSoundControl(new SoundControl() {
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
        Scene scene = new ClassicFroggerScene(gameSetting);
        Lane lane = new Lane(true, 50, 100, new Cars(scene), 200, scene);

        assertEquals(200, lane.getY());
    }

    @Test
    public void calX() {
        GameSetting gameSetting = new GameSetting(500, 500);
        gameSetting.put("holeNumber",3);
        gameSetting.setSoundControl(new SoundControl() {
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
        Scene scene = new ClassicFroggerScene(gameSetting);
        Lane lane = new Lane(true, 50, 100, new Cars(scene), 200, scene);

        assertEquals(0-50, lane.calX(50));

        Lane lane2 = new Lane(false, 50, 100, new Cars(scene), 200, scene);

        assertEquals(550, lane2.calX(50));

    }
}