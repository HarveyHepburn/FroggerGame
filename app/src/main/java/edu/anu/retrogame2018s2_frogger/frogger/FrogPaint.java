package edu.anu.retrogame2018s2_frogger.frogger;

public class FrogPaint {
    private TextAlign textAlign;
    private String color;
    private Integer textSize;
    private Boolean styleFill;

    public TextAlign getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(TextAlign textAlign) {
        this.textAlign = textAlign;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public Integer getTextSize() {
        return textSize;
    }

    public void setStyleFill(Boolean styleFill) {
        this.styleFill = styleFill;
    }

    public Boolean getStyleFill() {
        return styleFill;
    }
}
