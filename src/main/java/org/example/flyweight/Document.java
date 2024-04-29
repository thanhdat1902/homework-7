package org.example.flyweight;

import java.io.*;
import java.util.ArrayList;

public class Document {
    private String fileName;
    private final ArrayList<Character> characters = new ArrayList<>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public Document(String fileName) {
        this.fileName = fileName;
    }
    public void write(char character, CharacterStyle style) {
        characters.add(new Character(character, style));
    }
    public void edit(int charIndex, char newText ,CharacterStyle newStyle) {
        characters.get(charIndex).setText(newText);
        characters.get(charIndex).setStyle(newStyle);
    }
    public void saveToFile(String filepath) {
        try (PrintWriter writer = new PrintWriter(filepath)) {
            for (Character character : characters) {
                writer.println(character);
            }
            System.out.println("Document saved to file: " + filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFromFile(String filepath) {
        characters.clear(); // Clear existing characters before loading
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            CharacterStyleFactory factory = new CharacterStyleFactory();
            while ((line = reader.readLine()) != null) {
                String[] components = line.split(" ");
                if (components.length == 3) {
                    String[] style = components[2].substring( 1, components[2].length() - 1 ).split(",");
                    char value = components[1].charAt(0);
                    String font = style[0];
                    String color = style[1];
                    int size = Integer.parseInt(style[2]);
                    characters.add(new Character(value, factory.getCharacterStyle(font,color, size)));
                }
            }
            System.out.println("Document loaded from file: " + filepath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void view() {
        for (Character character : characters) {
            System.out.println(character);
        }
    }
}
