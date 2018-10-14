package edu.anu.retrogame2018s2_frogger;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

import edu.anu.retrogame2018s2_frogger.frogger.widget.SoundControl;

public class Sounds extends SoundControl {
    Context context;
    static MediaPlayer mediaPlayer;

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
    public void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }
}
