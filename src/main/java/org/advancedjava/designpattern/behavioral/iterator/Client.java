package org.advancedjava.designpattern.behavioral.iterator;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Book> booksList = List.of(
                new Book(100, "Science"),
                new Book(200, "Maths"),
                new Book(300, "GK"),
                new Book(400, "Drawing")
        );

        Library lib = new Library(booksList);
        Iterator iterator = lib.createIterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getBookName());
        }
    }
}
