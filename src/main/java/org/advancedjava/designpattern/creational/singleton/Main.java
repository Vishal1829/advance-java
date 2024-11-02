package org.advancedjava.designpattern.creational.singleton;

public class Main {
    public static void main(String[] args) {
        DBConnection1 connection1 = DBConnection1.getInstance();
        DBConnection2 connection2 = DBConnection2.getInstance();
        DBConnection3 connection3 = DBConnection3.getInstance();
        DBConnection4 connection4 = DBConnection4.getInstance();
    }
}
/*
Singleton Pattern:
It is used when we have to create only 1 instance of the class.

4 ways to achieve this:
1. Eager
2. Lazy
3. Synchronized Method
4. Double Locking (most preferred extensively used in industries)
 */

//1. Eager Initialization:
class DBConnection1 {

    private static DBConnection1 conObject = new DBConnection1();

    private DBConnection1() {

    }

    public static DBConnection1 getInstance() {
        return conObject;
    }
}

//2. Lazy Initialization:
class DBConnection2 {

    private static DBConnection2 conObject;

    private DBConnection2() {

    }

    public static DBConnection2 getInstance() {
        if (conObject == null) {
            conObject = new DBConnection2();
        }
        return conObject;
    }
}

//3. Synchronized Method:
class DBConnection3 {

    private static DBConnection3 conObject;

    private DBConnection3() {

    }

    synchronized public static DBConnection3 getInstance() {
        if (conObject == null) {
            conObject = new DBConnection3();
        }
        return conObject;
    }
}

//4. Double Locking:
class DBConnection4 {

    private static DBConnection4 conObject;

    private DBConnection4() {

    }

    public static DBConnection4 getInstance() {
        if (conObject == null) {
            synchronized (DBConnection4.class) {
                if (conObject == null) {
                    conObject = new DBConnection4();
                }
            }
        }
        return conObject;
    }
}