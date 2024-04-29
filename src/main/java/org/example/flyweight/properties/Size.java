package org.example.flyweight.properties;

public class Size {
    private int size;

    public Size(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
