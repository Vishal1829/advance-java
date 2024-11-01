package org.advancedjava.designpattern.behavioral.observer;

public class Client {
    public static void main(String[] args) {
        Blogs blogs = new Blogs();
        BlogSubscriber subscriber1 = new BlogSubscriber("vishal");
        BlogSubscriber subscriber2 = new BlogSubscriber("lakshay");
        BlogSubscriber subscriber3 = new BlogSubscriber("ravi");

        blogs.registerObserver(subscriber1);
        blogs.registerObserver(subscriber2);
        blogs.registerObserver(subscriber3);
        blogs.setBlogTitle("Something new.....");
    }
}
