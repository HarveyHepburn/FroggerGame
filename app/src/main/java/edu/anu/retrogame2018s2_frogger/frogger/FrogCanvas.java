package edu.anu.retrogame2018s2_frogger.frogger;

public interface FrogCanvas {
    void drawRect(float left, float top, float right, float bottom, FrogPaint frogPaint);
    void drawCircle(float cx, float cy, float radius, FrogPaint frogPaint);
    void drawPath(Path path, FrogPaint frogPaint);
    void drawText(String text, float x, float y, FrogPaint frogPaint);
    void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, FrogPaint paint);
}
