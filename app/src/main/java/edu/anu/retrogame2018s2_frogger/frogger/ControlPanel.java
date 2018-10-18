package edu.anu.retrogame2018s2_frogger.frogger;

import edu.anu.retrogame2018s2_frogger.frogger.scene.Scene;

/*
    Author: Yang Yu, Danny Feng
 */
public class ControlPanel {
    FrogPaint frogPaint1 = new FrogPaint();
    FrogPaint frogPaint2 = new FrogPaint();
    FrogPaint frogPaint3 = new FrogPaint();
    FrogPaint frogPaint4 = new FrogPaint();

    boolean onTouchN;
    boolean onTouchS;
    boolean onTouchE;
    boolean onTouchW;

    public ControlPanel(int x, int y, Scene scene) {
        this.x = x;
        this.y = y;
        this.scene = scene;
    }

    private Scene scene;
    private int x, y;

    public void draw(FrogCanvas frogCanvas) {
        FrogPaint frogPaint = new FrogPaint();
        frogPaint.setColor("#1E141414");
        frogCanvas.drawCircle(x, y, 200, frogPaint);

        Path p1 = getTriangle(new int[]{x - 50, y - 50}, 100, Direction.EAST);
        Path p2 = getTriangle(new int[]{x - 50, y - 50}, 100, Direction.NORTH);
        Path p3 = getTriangle(new int[]{x - 50, y + 50}, 100, Direction.SOUTH);
        Path p4 = getTriangle(new int[]{x + 50, y - 50}, 100, Direction.WEST);

        //each button has a all paint
        frogPaint1.setColor("#4db6ac");
        frogPaint1.setStyleFill(true);
        frogPaint2.setColor("#4db6ac");
        frogPaint2.setStyleFill(true);
        frogPaint3.setColor("#4db6ac");
        frogPaint3.setStyleFill(true);
        frogPaint4.setColor("#4db6ac");
        frogPaint4.setStyleFill(true);

        frogCanvas.drawPath(p1, frogPaint1);
        frogCanvas.drawPath(p2, frogPaint2);
        frogCanvas.drawPath(p3, frogPaint3);
        frogCanvas.drawPath(p4, frogPaint4);
        if (onTouchW) {
            frogPaint1.setColor("#e68a00");
            frogCanvas.drawPath(p1, frogPaint1);
        }
        if (onTouchS) {
            frogPaint2.setColor("#e68a00");
            frogCanvas.drawPath(p2, frogPaint2);
        }
        if (onTouchN) {
            frogPaint3.setColor("#e68a00");
            frogCanvas.drawPath(p3, frogPaint3);
        }
        if (onTouchE) {
            frogPaint4.setColor("#e68a00");
            frogCanvas.drawPath(p4, frogPaint4);
        }
    }

    public static Path getTriangle(int[] p1, int width, Direction direction) {
        int[] p2 = null, p3 = null;
        //the Path (three points) for each triangle
        if (direction == Direction.NORTH) {
            p2 = new int[]{p1[0] + width, p1[1]};
            p3 = new int[]{p1[0] + (width / 2), p1[1] - width};
        } else if (direction == Direction.SOUTH) {
            p2 = new int[]{p1[0] + width, p1[1]};
            p3 = new int[]{p1[0] + (width / 2), p1[1] + width};
        } else if (direction == Direction.EAST) {
            p2 = new int[]{p1[0], p1[1] + width};
            p3 = new int[]{p1[0] - width, p1[1] + (width / 2)};

        } else if (direction == Direction.WEST) {
            p2 = new int[]{p1[0], p1[1] + width};
            p3 = new int[]{p1[0] + width, p1[1] + (width / 2)};
        }

        Path path = new Path();
        path.add(p1);
        path.add(p2);
        path.add(p3);

        return path;
    }


    public void onTouch(float x, float y, boolean isDown) {

        if (!isDown) {
            onTouchN = false;
            onTouchS = false;
            onTouchE = false;
            onTouchW = false;
            frogPaint1.setColor("#4db6ac");
            frogPaint2.setColor("#4db6ac");
            frogPaint3.setColor("#4db6ac");
            frogPaint4.setColor("#4db6ac");
            scene.move(null);
            return;
        }
        if (x < this.x + 200 && x > this.x - 200 && y > this.y - 200 && y < this.y + 200) {
            x -= this.x;
            y -= this.y;
            //divide into four area, up, right, down, left.
            // Calculate the user touch on which area
            double angle = calculateAngle(0, 0, x, y);
            if (angle > 45 && angle < 135) {
                scene.move(Direction.EAST);
                onTouchE = true;//if touched, change colour
            } else if (angle > 135 && angle < 225) {
                scene.move(Direction.SOUTH);
                onTouchS = true;
            } else if (angle > 225 && angle < 315) {
                scene.move(Direction.WEST);
                onTouchW = true;

            } else {
                scene.move(Direction.NORTH);
                onTouchN = true;
            }
        }
    }

    public static double calculateAngle(double x1, double y1, double x2, double y2) {
        double angle = Math.toDegrees(Math.atan2(x2 - x1, y2 - y1));
        // Keep angle between 0 and 360
        angle = angle + Math.ceil(-angle / 360) * 360;

        return angle;
    }

}
