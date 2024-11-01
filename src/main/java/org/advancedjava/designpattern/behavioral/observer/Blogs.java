package org.advancedjava.designpattern.behavioral.observer;

import lombok.Getter;

@Getter
public class Blogs extends Subject {
    private String blogTitle;

    public void setBlogTitle(String newTitle) {
        this.blogTitle = newTitle;
        notifyObservers();
    }
}
