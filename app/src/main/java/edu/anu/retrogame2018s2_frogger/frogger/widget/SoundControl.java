package edu.anu.retrogame2018s2_frogger.frogger.widget;

public abstract class SoundControl {
    protected String currentPlaying=null;
    public abstract void playMusic(String musicName);
    public abstract void playSound(String musicName);
    public abstract void stopMusic();
    public abstract void stopSound();
    public abstract boolean isSoundPlaying();
}
