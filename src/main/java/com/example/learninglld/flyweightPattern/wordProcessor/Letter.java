package com.example.learninglld.flyweightPattern.wordProcessor;

public class Letter implements ICharacter {
    private char character;
    private String fontType;
    private Integer fontSize;

    public Letter(char character, String fontType, Integer fontSize) {
        this.character = character;
        this.fontType = fontType;
        this.fontSize = fontSize;
    }

    public char getCharacter() {
        return character;
    }

    public String getFontType() {
        return fontType;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    @Override
    public void display(int x, int y) {
        //render character at (x, y) using fontType and fontSize
    }
}
