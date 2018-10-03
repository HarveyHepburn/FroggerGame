package edu.anu.retrogame2018s2_frogger.frogger;

public class SceneEndInformation {

    boolean win;
    String info;

    SceneEndInformation(boolean win, String info) {
        this.win = win;
        this.info = info;
    }

    public String getBackgroudColor() {
        return null;
    }

    public String getInformation() {
        return info;
    }
}
