package edu.anu.retrogame2018s2_frogger.frogger;

public class FrogPaint {
    private String Color = null;
    private Boolean StyleFill = null;
    private Integer TextSize = null;
    private TextAlign textAlign;
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
