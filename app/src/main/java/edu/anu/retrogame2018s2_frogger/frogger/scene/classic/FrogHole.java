package edu.anu.retrogame2018s2_frogger.frogger.scene.classic;

import java.util.Set;
import java.util.HashSet;

import edu.anu.retrogame2018s2_frogger.frogger.Drawable;
import edu.anu.retrogame2018s2_frogger.frogger.Frog;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

public class FrogHole implements Drawable {

    FrogPaint frogPaintBg;
    FrogPaint frogPaintHole;
    FrogPaint frogPaintHoleIn;
    private Scene scene;
    int holeNumber = 1;
    Set<Integer> inHoleNum = new HashSet<>();
    int wallHeight = 100;
    int holeWidth = 100;

    public FrogHole(Scene scene) {
        this.scene = scene;
        this.frogPaintBg = new FrogPaint();
        frogPaintBg.setColor("#3e2723");
        frogPaintBg.setStyleFill(true);
        frogPaintHole = new FrogPaint();
        frogPaintHole.setColor("#ffffff");
        frogPaintHole.setStyleFill(true);
        frogPaintHoleIn = new FrogPaint();
        frogPaintHoleIn.setColor("#33691e");
        frogPaintHoleIn.setStyleFill(true);
        this.holeNumber = scene.getGameSetting().get("holeNumber");
    }

    @Override
    public void draw(FrogCanvas frogCanvas) {
        frogCanvas.drawRect(0, 0, scene.getGameSetting().getWidth(), wallHeight, frogPaintBg);
        for (int i = 0; i < holeNumber; i++) {
            int mid = (scene.getGameSetting().getWidth() / (holeNumber + 1)) * (i + 1);
            if (inHoleNum.contains(i)) {
                frogCanvas.drawCircle(mid, wallHeight, holeWidth, frogPaintHoleIn);
            } else {
                frogCanvas.drawCircle(mid, wallHeight, holeWidth, frogPaintHole);
            }
        }
    }

    public boolean inHole(Frog frog) {
        if (frog.getY() < wallHeight) {
            for (int i = 0; i < holeNumber; i++) {
                int mid = (scene.getGameSetting().getWidth() / (holeNumber + 1)) * (i + 1);
                if (frog.getX() < mid + holeWidth / 2 && frog.getX() > mid - holeWidth / 2) {
                    inHoleNum.add(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFinished() {
        if (this.inHoleNum.size() >= holeNumber) {
            return true;
        }
        return false;
    }

    public boolean isOkToMove(int x, int y) {
        if (y > wallHeight) {
            return true;
        } else {
            for (int i = 0; i < holeNumber; i++) {
                int mid = (scene.getGameSetting().getWidth() / (holeNumber + 1)) * (i + 1);
                if (x < mid + holeWidth / 2 && x > mid - holeWidth / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void step() {

    }
}