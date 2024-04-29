package org.example.flyweight.properties;

public class Font {
    private String font;

    public Font(String font) {
        this.font = font;
    }
    @Override
    public String toString() {
        return font;
    }
}