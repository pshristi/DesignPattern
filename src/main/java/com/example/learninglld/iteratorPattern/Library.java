package com.example.learninglld.iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Iterator createIterator() {
        return new BookIterator(this.books);
    }
}
