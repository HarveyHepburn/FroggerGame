
package edu.anu.retrogame2018s2_frogger;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.Path;

public class UsingCanvas implements FrogCanvas {
    Canvas canvas;
    Resources res;
    String thePackage;

    public UsingCanvas(Canvas canvas, Resources res, String thePackage) {
        this.canvas = canvas;
        this.res = res;
        this.thePackage = thePackage;
    }

    @Override
    public void drawRect(float left, float top, float right, float bottom, FrogPaint frogPaint) {
        canvas.drawRect(left, top, right, bottom, getPaint(frogPaint));
    }

    @Override
    public void drawCircle(float cx, float cy, float radius, FrogPaint frogPaint) {
        canvas.drawCircle(cx, cy, radius, getPaint(frogPaint));
    }

    @Override
    public void drawPath(Path path, FrogPaint frogPaint) {
        canvas.drawPath(getPath(path), getPaint(frogPaint));
    }

    @Override
    public void drawText(String text, float x, float y, FrogPaint frogPaint) {
        canvas.drawText(text, x, y, getPaint(frogPaint));
    }

    @Override
    public void drawImage(String image, int left, int top, int right, int bottom, FrogPaint frogPaint) {
        if(image.endsWith(".***")){
            image=image.substring(0,image.length()-4);
        }
        int drawableResourceId = res.getIdentifier(image, "drawable", thePackage);
        android.graphics.drawable.Drawable d = res.getDrawable(drawableResourceId);
        d.setBounds(left,top,right,bottom);
        d.draw(canvas);
    }

    @Override
    public void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, FrogPaint paint) {
        canvas.drawRoundRect(left, top, right, bottom, rx, ry, getPaint(paint));
    }

    static android.graphics.Paint getPaint(FrogPaint frogPaint) {
        android.graphics.Paint paint = new android.graphics.Paint();
        if (frogPaint.getColor() != null) {
            paint.setColor(Color.parseColor(frogPaint.getColor()));
        }
        if (frogPaint.getStyleFill() != null) {
            paint.setStyle(android.graphics.Paint.Style.FILL);
        }
        if (frogPaint.getTextSize() != null) {
            paint.setTextSize(frogPaint.getTextSize());
        }
        if (frogPaint.getTextAlign() != null) {
            switch (frogPaint.getTextAlign()) {
                case Center:
                    paint.setTextAlign(Paint.Align.CENTER);
                    break;
            }
        }
//        paint.setTextAlign(Paint.Align.CENTER);
        return paint;
    }

    static android.graphics.Path getPath(Path path) {
        android.graphics.Path p = new android.graphics.Path();
        if (path.size() >= 1) {
            p.moveTo(path.get(0)[0], path.get(0)[1]);
        }
        for (int i = 1; i < path.size(); i++) {
            p.lineTo(path.get(i)[0], path.get(i)[1]);
        }
        return p;
    }
}
