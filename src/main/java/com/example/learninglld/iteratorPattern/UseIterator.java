package com.example.learninglld.iteratorPattern;

import java.util.Iterator;

public class UseIterator {
    public static void useIterator() {
        Book book1 = new Book("Book1", 100);
        Book book2 = new Book("Book2", 250);
        Book book3 = new Book("Book3", 175);
        Book book4 = new Book("Book4", 345);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Iterator iterator = library.createIterator();
        if(iterator.hasNext()) {
            Book next = (Book) iterator.next();
            System.out.println(next.getName());
        }

    }
}
