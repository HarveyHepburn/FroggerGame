package edu.anu.retrogame2018s2_frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.logging.Handler;

public class GameView extends View implements View.OnTouchListener, Runnable {

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
        timer = new android.os.Handler();
        timer.postDelayed(this,10);
        }
    android.os.Handler timer;

    @Override
    protected void onDraw(Canvas canvas) {
        //TODO
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //TODO
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        invalidate();
        return true;
    }

    @Override
    public void run() {
        //TODO
    }
}
