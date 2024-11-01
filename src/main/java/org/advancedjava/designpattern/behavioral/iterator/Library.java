package org.advancedjava.designpattern.behavioral.iterator;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Library {
    private List<Book> booksList;

    public Iterator createIterator() {
        return new BookIterator(booksList);
    }
}
