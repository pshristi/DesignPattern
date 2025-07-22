package com.example.learninglld.flyweightPattern.wordProcessor;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    private Map<Character, ICharacter> characterPool = new HashMap<>();

    public ICharacter getCharacter(char character) {
        if(!characterPool.containsKey(character)) {
            characterPool.put(character, new Letter(character, "Arial", 12));
        }
        return characterPool.get(character);
    }
}
