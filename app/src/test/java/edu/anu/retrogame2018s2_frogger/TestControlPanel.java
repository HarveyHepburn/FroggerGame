package edu.anu.retrogame2018s2_frogger;

import org.junit.Test;

import java.util.ArrayList;

import edu.anu.retrogame2018s2_frogger.frogger.ControlPanel;
import edu.anu.retrogame2018s2_frogger.frogger.Direction;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestControlPanel {

    @Test
    public void calculateAngle_vertical_isCorrect() {
        assertEquals(90.0, ControlPanel.calculateAngle(0, 0, 5, 0), .5);
        assertEquals(270.0, ControlPanel.calculateAngle(0, 0, -10, 0), .5);
    }

    @Test
    public void calculateAngle_level_isCorrect() {
        assertEquals(180.0, ControlPanel.calculateAngle(0, 0, 0, -30), .5);
        assertEquals(0.0, ControlPanel.calculateAngle(0, 0, 0, 0), .5);
    }

    @Test
    public void calculateAngle_isCorrect() {
        assertEquals(45.0, ControlPanel.calculateAngle(100, 200, 300, 400), .5);
        assertEquals(87.7, ControlPanel.calculateAngle(0, 0, 500, 20), .5);
        assertEquals(18.4, ControlPanel.calculateAngle(0, 0, 1, 3), .5);
        assertEquals(191.0, ControlPanel.calculateAngle(0, 0, -10, -50), .5);
    }

    @Test
    public void getTriangle_isCorrect() {
        ArrayList<int[]> res;
        res = ControlPanel.getTriangle(new int[]{50, 30}, 100, Direction.EAST);
        assertEquals(50, res.get(0)[0], .9);
        assertEquals(30, res.get(0)[1], .9);
        assertEquals(50, res.get(1)[0], .9);
        assertEquals(130, res.get(1)[1], .9);
        assertEquals(-50, res.get(2)[0], .9);
        assertEquals(80, res.get(2)[1], .9);
    }
}