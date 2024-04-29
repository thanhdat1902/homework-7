package org.example.flyweight;
public class Driver {
    public static void main(String[] args) {
        CharacterStyleFactory flyweightfactory = new CharacterStyleFactory();
        String fileName = "NewDocument.txt";
        String filePath = "/Users/datnguyen/Downloads/5800 - Software/Homework-7/assets/";
        Document document = new Document(fileName);
        document.write('H',flyweightfactory.getCharacterStyle("Arial","Red",12));
        document.write('e',flyweightfactory.getCharacterStyle("Arial","Red",12));
        document.write('l',flyweightfactory.getCharacterStyle("Arial","Red",12));
        document.write('l',flyweightfactory.getCharacterStyle("Arial","Red",12));
        document.write('o',flyweightfactory.getCharacterStyle("Arial","Red",12));

        document.write('W',flyweightfactory.getCharacterStyle("Calibri","Blue",14));
        document.write('o',flyweightfactory.getCharacterStyle("Calibri","Blue",14));
        document.write('r',flyweightfactory.getCharacterStyle("Calibri","Blue",14));
        document.write('l',flyweightfactory.getCharacterStyle("Calibri","Blue",14));
        document.write('d',flyweightfactory.getCharacterStyle("Calibri","Blue",14));

        document.write('C',flyweightfactory.getCharacterStyle("Verdana","Black",16));
        document.write('S',flyweightfactory.getCharacterStyle("Verdana","Black",16));

        document.write('5',flyweightfactory.getCharacterStyle("Roboto","Yellow",18));
        document.write('8',flyweightfactory.getCharacterStyle("Roboto","Yellow",18));
        document.write('0',flyweightfactory.getCharacterStyle("Roboto","Yellow",18));
        document.write('0',flyweightfactory.getCharacterStyle("Roboto","Yellow",18));

        document.view();


        System.out.println("================== Editing character =====================");
        document.edit(4, 'O', flyweightfactory.getCharacterStyle("Verdana","Black",16));
        document.view();

        System.out.println("================== Saving document =====================");
        document.saveToFile( filePath + fileName);


        System.out.println("================== Loading document =====================");
        String loadDocumentName = "load-document.txt";
        Document newDocument = new Document(loadDocumentName);
        newDocument.loadFromFile( filePath + loadDocumentName);
        newDocument.view();
    }
}