package org.advancedjava.designpattern.behavioral.observer;

public class BlogSubscriber implements Observer {

    private String name;

    public BlogSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + ": blog title changed");
    }
}
