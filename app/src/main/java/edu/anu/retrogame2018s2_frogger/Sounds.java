package edu.anu.retrogame2018s2_frogger;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;

public class Sounds extends SoundControl {
    Context context;
    static MediaPlayer mediaPlayer;
    static MediaPlayer mediaPlayerSoundEffect;

    public Sounds(Context context) {
        this.context = context;
    }

    @Override
    public void playMusic(String musicName) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        mediaPlayer = new MediaPlayer();
        System.out.println(mediaPlayer.isPlaying());
        try {
            AssetFileDescriptor afd = null;
            afd = context.getAssets().openFd(musicName);
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
            super.currentPlaying = musicName;
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void playSound(String musicName) {
        if (mediaPlayerSoundEffect != null) {
            mediaPlayerSoundEffect.stop();
            mediaPlayerSoundEffect.release();
        }
        mediaPlayerSoundEffect = new MediaPlayer();
        System.out.println(mediaPlayerSoundEffect.isPlaying());
        try {
            AssetFileDescriptor afd = null;
            afd = context.getAssets().openFd(musicName);
            mediaPlayerSoundEffect.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mediaPlayerSoundEffect.prepare();
            mediaPlayerSoundEffect.setLooping(true);
            super.currentPlaying = musicName;
            mediaPlayerSoundEffect.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }
    @Override
    public void stopSound() {
        if (mediaPlayerSoundEffect != null && mediaPlayerSoundEffect.isPlaying()) {
            mediaPlayerSoundEffect.stop();
        }
    }

    @Override
    public boolean isSoundPlaying() {
        return mediaPlayerSoundEffect != null&&mediaPlayerSoundEffect.isPlaying();
    }
}
