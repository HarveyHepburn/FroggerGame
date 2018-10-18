package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;


import edu.anu.retrogame2018s2_frogger.frogger.ControlPanel;
import edu.anu.retrogame2018s2_frogger.frogger.Dialog;
import edu.anu.retrogame2018s2_frogger.frogger.DialogInformation;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FroggerGame;
import edu.anu.retrogame2018s2_frogger.frogger.GameSetting;
import edu.anu.retrogame2018s2_frogger.frogger.RecordInfo;
import edu.anu.retrogame2018s2_frogger.frogger.SceneFactory;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

/**
 * @Author: Yu Yang (Harvey), Boyuan Zheng(Joe)
 */
public class ClassicFroggerScene implements Scene {
    private GameSetting gameSetting;
    private Frog frog;
    private Logs logs;
    private Cars cars;
    private Background background;
    private ControlPanel controlPanel;
    private Timer timer;
    private Star star;

    public Dialog getDialog() {
        return dialog;
    }

    private FrogHole frogHole;
    private Dialog dialog = null;

    public ClassicFroggerScene(GameSetting gameSetting) {
        this.isActive = true;
        this.gameSetting = gameSetting;
        this.gameSetting.setFrog(frog);
        this.frog = new Frog(this);
        this.gameSetting.setFrog(this.frog);
        this.timer = new Timer(this);
        this.star = new Star(this, timer);

        background = new Background(this);
        cars = new Cars(this);
        logs = new Logs(this);
        this.frogHole = new FrogHole(this);
        controlPanel = new ControlPanel(gameSetting.getWidth() - 300, gameSetting.getHeight() - 300, this);

        for (int i = 0; i < 200; i++) {
            step();
        }
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogHole.draw(frogCanvas);
        background.draw(frogCanvas);
        logs.draw(frogCanvas);
        frog.draw(frogCanvas);
        cars.draw(frogCanvas);
        controlPanel.draw(frogCanvas);
        timer.draw(frogCanvas);
        star.draw(frogCanvas);
        if (isActive && this.frogHole.inHole(frog)) {
            if (this.frogHole.isFinished()) {
                sceneOver(new DialogInformation("Mission Accomplished !"));
            } else {
                this.frog.resetFrog();
            }
        }
    }

    @Override
    public void step() {
        if (isActive) {
            cars.step();
            if (this.frog.getLog() == null && this.frog.getY() >= gameSetting.get("riverTop") && frog.getY() < gameSetting.get("riverBottom")) {
                sceneOver(new DialogInformation("You dropped into the river !"));
            }

            frog.step();
            logs.step();
            timer.step();
            star.step();
        } else {
            if (dialog != null)
                dialog.step();
            this.getGameSetting().getSoundControl().stopSound();

        }
    }

    @Override
    public void onEnterScene(FrogCanvas frogCanvas) {

    }

    @Override
    public void onFinishScene(FrogCanvas frogCanvas) {
        if (this.dialog != null) {
            this.dialog.draw(frogCanvas);
        }
    }

    @Override
    public void sceneOver(DialogInformation sceneEndInformation) {
        isActive = false;
        this.dialog = new Dialog(sceneEndInformation, gameSetting);
    }

    @Override
    public GameSetting getGameSetting() {
        return gameSetting;
    }

    public void move(Direction direction) {
        this.frog.move(direction);
    }

    @Override
    public String onBackPressed() {
        if (isActive) {
            isActive = false;
            this.dialog = new Dialog(new DialogInformation("Paused, press back again to quit"), gameSetting);
        } else {
            return "levels";
        }

        return null;
    }

    @Override
    public boolean isMoveble(int x, int y) {
        if(x<=0||x>=gameSetting.getWidth()||y<=0||y>=gameSetting.getHeight()){
            return false;
        }
        return this.frogHole.isOkToMove(x, y);
    }

    @Override
    public String onTouch(float x, float y, boolean isDown) {
        if (isActive) {
            this.controlPanel.onTouch(x, y, isDown);
        } else if (this.dialog != null) {
            if (this.dialog.gotClick(x, y)) {
                if (this.dialog.dialogInformation.getInformation().equals("Paused, press back again to quit")) {
                    this.isActive = true;
                    return null;
                } else if (this.dialog.dialogInformation.getInformation().equals("Mission Accomplished !")) {
                    String name = PlayerStore.load();
                    RecordInfo record = new RecordInfo(name, frogHole.holeNumber, timer.getTime());
                    gameSetting.getDbManager().addData(record);
                    return "ranking";
                }
                return "levels";
            }
        }
        return null;
    }

    private boolean isActive;

    @Override
    public boolean isActive() {
        return isActive;
    }

}