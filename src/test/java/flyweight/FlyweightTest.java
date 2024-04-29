package flyweight;

import org.example.flyweight.Character;
import org.example.flyweight.CharacterStyle;
import org.example.flyweight.CharacterStyleFactory;
import org.example.flyweight.Document;
import org.example.flyweight.properties.Color;
import org.example.flyweight.properties.Font;
import org.example.flyweight.properties.Size;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlyweightTest {
    @Test
    public void characterTest() {
        Character c = new Character('a', new CharacterStyle(new Font("Arial"), new Color("red"), new Size(12)));
        assertEquals(c.getText(), 'a');
        assertEquals(c.getStyle().getFont().toString(), "Arial");
        assertEquals(c.getStyle().getColor().toString(), "red");
        assertEquals(c.getStyle().getSize().toString(), "12");

    }
    @Test
    public void documentWriteTest() {
        Document doc = new Document("abc.txt");
        doc.write('a',  new CharacterStyle(new Font("Arial"), new Color("red"), new Size(12)));
        ArrayList<Character> characters = doc.getCharacters();
        assertEquals(characters.get(0).getText(), 'a');
        assertEquals(characters.get(0).getStyle().getColor().toString(), "red");
        assertEquals(characters.get(0).getStyle().getFont().toString(), "Arial");
        assertEquals(characters.get(0).getStyle().getSize().toString(), "12");
    }
    @Test
    public void documentEditTest() {
        Document doc = new Document("abc.txt");
        doc.write('a',  new CharacterStyle(new Font("Arial"), new Color("red"), new Size(12)));
        doc.edit(0, 'b', new CharacterStyle(new Font("Times"), new Color("yellow"), new Size(11)));
        ArrayList<Character> characters = doc.getCharacters();
        assertEquals(characters.get(0).getText(), 'b');
        assertEquals(characters.get(0).getStyle().getColor().toString(), "yellow");
        assertEquals(characters.get(0).getStyle().getFont().toString(), "Times");
        assertEquals(characters.get(0).getStyle().getSize().toString(), "11");
    }
    @Test
    public void instanceFactoryTest() {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        CharacterStyle char1 = factory.getCharacterStyle("Times", "red", 12);
        CharacterStyle char2 = factory.getCharacterStyle("Times", "red", 12);
        // Same instance (not created new instance)
        assertEquals(char1, char2);
    }
}
