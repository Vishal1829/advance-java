package org.advancedjava.designpattern.structural.proxy.dbexample;

public class DataBase {

    public DataBase() {

    }

    void execute(String QueryType,String id)
    {
        System.out.println("executing the query : " + QueryType);
    }
}
