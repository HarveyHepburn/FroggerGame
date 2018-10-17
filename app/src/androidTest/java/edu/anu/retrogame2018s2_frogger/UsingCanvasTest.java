package edu.anu.retrogame2018s2_frogger;

import android.graphics.Color;
import android.graphics.Paint;

import org.junit.Test;

import edu.anu.retrogame2018s2_frogger.frogger.Direction;
import edu.anu.retrogame2018s2_frogger.frogger.FrogPaint;

import static org.junit.Assert.*;

public class UsingCanvasTest {

    @Test
    public void getPaintTest() {
        FrogPaint frogPaint=new FrogPaint();
        frogPaint.setColor("#ffffff");
        frogPaint.setDirection(Direction.NORTH);
        frogPaint.setTextAlign(FrogPaint.TextAlign.Center);
        frogPaint.setStyleFill(true);

        Paint paint=UsingCanvas.getPaint(frogPaint);
        assertEquals(Color.parseColor("#ffffff"),paint.getColor());
        assertEquals(Paint.Align.CENTER,paint.getTextAlign());
        assertEquals(android.graphics.Paint.Style.FILL,paint.getStyle());
    }

    @Test
    public void getPathTest() {
    }
}