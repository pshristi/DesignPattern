package com.example.learninglld.mementoOrSnapshotPattern;

public class UseMemento {
    public static void useMemento() {
        ConfigurationOriginator originator = new ConfigurationOriginator(100, 200);
        ConfigurationCaretaker caretaker = new ConfigurationCaretaker();

        // Save the current state
        ConfigurationMemento snapshot1 = originator.createMemento();
        caretaker.addMemento(snapshot1);

        // Change the state
        originator.height = 50;
        originator.width = 150;

        ConfigurationMemento snapshot2 = originator.createMemento();
        caretaker.addMemento(snapshot2);

        // Change the state
        originator.height = 50;
        originator.width = 150;

        // Undo the changes
        ConfigurationMemento memento = caretaker.undo();
        originator.restoreFromMemento(memento);

        System.out.println("Originator State after undo: Height = " + originator.getHeight() + ", Width = " + originator.getWidth());
    }
}
