package org.example.flyweight;

import org.example.flyweight.properties.Color;
import org.example.flyweight.properties.Font;
import org.example.flyweight.properties.Size;

public class CharacterStyle {
    // Use this for testing purposes. noOfObjects is used for calculating how much instances created during runtime.
    static int noOfObjects = 0;
    {
        noOfObjects += 1;
    }

    private Font font;
    private Color color;
    private Size size;
    public CharacterStyle() {};
    public CharacterStyle(Font font, Color color, Size size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }



    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}