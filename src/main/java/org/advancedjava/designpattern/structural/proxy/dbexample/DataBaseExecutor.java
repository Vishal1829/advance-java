package org.advancedjava.designpattern.structural.proxy.dbexample;

public interface DataBaseExecutor
{
    //the executor can be of type admin or non admin
    //admin can execute the query on the database
    //non admin can also execute the query on the database
    void executeQuery(String Type);
}
