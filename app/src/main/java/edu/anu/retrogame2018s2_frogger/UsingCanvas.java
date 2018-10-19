
package edu.anu.retrogame2018s2_frogger;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import java.util.HashMap;

import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.FrogCanvas;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;
import edu.anu.retrogame2018s2_frogger.frogger.Path;

/*
    Author: Yang Yu
 */

//we don't want to rely on android Canvas because that makes us hard to move the game across
//different patten. this is the class that connects our canvas to android canvas
public class UsingCanvas implements FrogCanvas {
    Canvas canvas;
    Resources res;
    String thePackage;

    HashMap<String, Drawable> imagesHash = new HashMap<>();

    public UsingCanvas(Resources res, String thePackage) {
        this.res = res;
        this.thePackage = thePackage;
    }

    Bitmap bitmap;

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
        android.graphics.drawable.Drawable d = imagesHash.get(image);
        if (d == null) {
            if (image.endsWith(".***")) {
                image = image.substring(0, image.length() - 4);
            }
            int drawableResourceId = res.getIdentifier(image, "drawable", thePackage);
            d = res.getDrawable(drawableResourceId);
            this.imagesHash.put(image,d);
        }

        d.setBounds(left, top, right, bottom);
        d.draw(canvas);
    }

    private android.graphics.drawable.Drawable createImageDrawble(String image) {
        int drawableResourceId = res.getIdentifier(image, "drawable", thePackage);
        android.graphics.drawable.Drawable d = res.getDrawable(drawableResourceId);
        return d;
    }

    private android.graphics.drawable.Drawable getFrogDrawable(String image, Direction direction) {
        String s = "";
        if (direction != null)
            switch (direction) {
                case NORTH:
                    s = "_down";
                    break;
                case WEST:
                    s = "_left";
                    break;
                case EAST:
                    s = "_right";
                    break;
            }
        int drawableResourceId = res.getIdentifier(image + s, "drawable", thePackage);
        android.graphics.drawable.Drawable d = res.getDrawable(drawableResourceId);
        return d;
    }


    @Override
    public void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, FrogPaint paint) {
        canvas.drawRoundRect(left, top, right, bottom, rx, ry, getPaint(paint));
    }

    static android.graphics.Paint getPaint(FrogPaint frogPaint) {

        android.graphics.Paint paint = new android.graphics.Paint();
        if (frogPaint == null) {
            return null;
        }
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
