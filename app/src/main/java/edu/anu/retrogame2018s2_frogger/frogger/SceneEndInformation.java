package edu.anu.retrogame2018s2_frogger.frogger;

public class SceneEndInformation { // implements  DialogInformation

    boolean win;
    String info;

    SceneEndInformation(boolean win, String info) {
        this.win = win;
        this.info = info;
    }

    public String getBackgroudColor() {
        if (win) {
            return "#AA000000";
        } else {
            return "#AA000000";
        }
    }

    public String getInformation() {
        return info;
    }
}
