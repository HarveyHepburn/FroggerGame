package edu.anu.retrogame2018s2_frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements View.OnTouchListener, Runnable {

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //TODO
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //TODO
        return false;
    }

    @Override
    public void run() {
        //TODO
    }
}
