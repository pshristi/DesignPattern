package com.example.learninglld.iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookIterator implements Iterator {
    List<Book> books = new ArrayList<Book>();
    Integer current;

    public BookIterator(List<Book> books) {
        this.books = books;
        current = 0;
    }

    @Override
    public boolean hasNext() {
        if(current < books.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Book next() {
        if(this.hasNext()) {
            return books.get(current++);
        }
        return null;
    }
}
