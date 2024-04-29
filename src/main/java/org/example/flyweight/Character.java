package org.example.flyweight;

public class Character {
    private char text;
    private CharacterStyle style;

    public Character(char text, CharacterStyle style) {
        this.text = text;
        this.style = style;
    }

    @Override
    public String toString() {
        return "Char: " + text + " [" + style.getFont() + "," + style.getColor() +
                "," + style.getSize() + "]";
    }

    public char getText() {
        return text;
    }

    public void setText(char text) {
        this.text = text;
    }

    public CharacterStyle getStyle() {
        return style;
    }
    public void setStyle(CharacterStyle style) {
        this.style = style;
    }
}
