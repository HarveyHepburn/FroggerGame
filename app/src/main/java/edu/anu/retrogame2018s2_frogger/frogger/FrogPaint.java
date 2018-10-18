package edu.anu.retrogame2018s2_frogger.frogger;

//Frog paint is to decoupling from Android Paint so that it can easily move to different platform
public class FrogPaint {
    private String Color = null;
    private Boolean StyleFill = null;
    private Integer TextSize = null;
    private TextAlign textAlign;
    private Direction direction = null;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {

        return direction;
    }

    public enum TextAlign {
        Center
    }

    public void setTextAlign(TextAlign textAlign) {
        this.textAlign = textAlign;
    }

    public TextAlign getTextAlign() {
        return textAlign;
    }


    public void setColor(String color) {
        Color = color;
    }

    public Integer getTextSize() {
        return TextSize;
    }

    public void setTextSize(int textSize) {
        TextSize = textSize;
    }

    public void setStyleFill(Boolean styleFill) {
        StyleFill = styleFill;
    }

    public String getColor() {
        return Color;
    }

    public Boolean getStyleFill() {
        return StyleFill;
    }
}
