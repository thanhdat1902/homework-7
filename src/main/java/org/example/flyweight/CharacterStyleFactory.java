package org.example.flyweight;

import org.example.flyweight.properties.Color;
import org.example.flyweight.properties.Font;
import org.example.flyweight.properties.Size;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CharacterStyleFactory {
    private final Map<Integer, CharacterStyle> charStyleHashTable = new HashMap<>();

    private final Map<String, Font> fonts = new HashMap<>();
    private final Map<Integer, Size> sizes = new HashMap<>();
    private final Map<String, Color> colors = new HashMap<>();


    private void addNewStyleProperties(String font, String color, int size) {
        if (!fonts.containsKey(font)) {
            fonts.put(font, new Font(font));
        }
        if (!colors.containsKey(color)) {
            colors.put(color, new Color(color));
        }
        if (!sizes.containsKey(size)) {
            sizes.put(size, new Size(size));
        }
    }
    public CharacterStyle getCharacterStyle(String font, String color, int size) {
        int key = Objects.hash(font, color, size);
        if (!charStyleHashTable.containsKey(key)) {
            addNewStyleProperties(font, color, size);
            Font currentFont = fonts.get(font);
            Color currentColor = colors.get(color);
            Size currentSize = sizes.get(size);
            charStyleHashTable.put(key, new CharacterStyle(currentFont, currentColor, currentSize));
        }
        return charStyleHashTable.get(key);
    }
}
