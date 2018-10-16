package edu.anu.retrogame2018s2_frogger;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import edu.anu.retrogame2018s2_frogger.frogger.FroggerGame;

public class GameView extends View implements View.OnTouchListener, Runnable {
    Handler timer = new Handler();
    FroggerGame froggerGame;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        froggerGame = new FroggerGame(getWidth(), getHeight(), new Sounds(getContext()),
                new RankDatabaseHelper(getContext(), null, null, 1));
        timer.postDelayed(this, 30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        froggerGame.draw(new UsingCanvas(canvas, getResources(), BuildConfig.APPLICATION_ID));
    }

    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            froggerGame.onTouch(motionEvent.getX(), motionEvent.getY(), true);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            froggerGame.onTouch(motionEvent.getX(), motionEvent.getY(), false);
        }
        return true;
    }

    @Override
    public void run() {
        froggerGame.step();
        invalidate();
        timer.postDelayed(this, 30);
    }

}
