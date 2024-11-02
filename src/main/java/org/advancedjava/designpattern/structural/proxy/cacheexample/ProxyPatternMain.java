package org.advancedjava.designpattern.structural.proxy.cacheexample;

public class ProxyPatternMain {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        image1.display(); // Image 1 will be loaded and displayed
        image2.display(); // Image 2 will be loaded and displayed

        // Image 1 is already loaded, so it will be displayed without loading again
        image1.display();
    }
}
