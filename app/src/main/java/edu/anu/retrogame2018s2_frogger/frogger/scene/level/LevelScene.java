package edu.anu.retrogame2018s2_frogger.frogger.scene.level;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelScene /*implements Scene*/ {
//    List<LevelButton> levelButtons;
//
//    public LevelScene(GameSetting gameSetting) {
//        levelButtons = new ArrayList<>();
//        Random random = new Random();
//        int gap = gameSetting.getWidth() / (gameSetting.get("levels") + 1);
//        for (int i = 0; i < gameSetting.get("levels"); i++) {
//            int y = i % 2 == 0 ? 300 : 700;
//            y += random.nextBoolean() ? 60 : 0;
//            levelButtons.add(new LevelButton(gap * (i + 1), y, i + 1));
//        }
//    }
//
//    @Override
//    public void onEnterScene(FrogCanvas frogCanvas) {
//
//    }
//
//    @Override
//    public void onFinishScene(FrogCanvas frogCanvas) {
//
//    }
//
//    @Override
//    public void sceneOver(SceneEndInformation sceneEndInformation) {
//
//    }
//
//    @Override
//    public void move(ControlPanel.Direction direction) {
//
//    }
//
//    @Override
//    public boolean isMoveble(int x, int y) {
//        return false;
//    }
//
//    @Override
//    public Integer onTouch(float x, float y, boolean isDown) {
//        for (LevelButton levelButton : this.levelButtons) {
//            if (levelButton.isClickOn(x, y))
//                return levelButton.level;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean isActive() {
//        return false;
//    }
//
//    @Override
//    public GameSetting getGameSetting() {
//        return null;
//    }
//
//    @Override
//    public void draw(FrogCanvas frogCanvas) {
//        for (LevelButton levelButton : this.levelButtons) {
//            levelButton.draw(frogCanvas);
//        }
//    }
//
//    @Override
//    public void step() {
//        for (LevelButton levelButton : this.levelButtons) {
//            levelButton.step();
//        }
//    }
}