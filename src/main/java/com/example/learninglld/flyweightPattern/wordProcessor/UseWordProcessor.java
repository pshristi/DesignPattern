package com.example.learninglld.flyweightPattern.wordProcessor;

public class UseWordProcessor {
    public static void useWordProcessor() {
        /*
            this is the data we want to write into the word processor.

            Total = 58 characters
            t = 7 times
            h = 3 times
            a = 3 times and so on...

         */
        LetterFactory letterFactory = new LetterFactory();
        ICharacter t = letterFactory.getCharacter('t');
        ICharacter h = letterFactory.getCharacter('h');
        ICharacter a = letterFactory.getCharacter('a');
        int i = 0;
        t.display(0, i++);
        h.display(0, i++);

    }
}
