package org.advancedjava.designpattern.adapter;

/*
Here in this program we have a webservice which takes a request as a json and do something. But our client is sending
request as an object but our webservice only takes json as a request so here there is a compatibility issue. So what we
do is create an interface and that interface will be implemented by a class which we called an adapter and
it will have the webservice in it basically it is a wrapper over webservice and what it does is takes the request
from client and converts it into json and send this request to the webservice and gets the response
and send it back to the client. So for the client the webservice(adaptee) is hidden as it is being wrapped by adapter.

https://www.notion.so/Coursera-Design-Patterns-91c225be182b480cb36d3fb7ba857e5b?pvs=4#029292d0e25e4709ae26961372fbfa01
 */

public class Program {
    public static void main(String[] args) {
        String webHost = "https://google.com";
        WebService service = new WebService(webHost);
        WebAdapter adapter = new WebAdapter();
        adapter.connect(service);
        WebClient client = new WebClient(adapter);
        client.doWork();
    }
}
/*
Adapter design pattern:
The adapter essentially encapsulates the adaptee and presents a new interface, or appearance, to the client class.
It does this by wrapping adaptee's interface and exposing a new target interface that makes sense to the client.

Steps to follow:-
1. Design the target interface
2. Implement the target interface with the adapter class
3. Send the request from the client to adapter using the target interface

What are the characteristics of the adapter design pattern?
- The client and adaptee classes have incompatible interfaces.
- An adapter is a wrapper class that wraps the adaptee, hiding it from the client.
- The client sends requests indirectly to the adaptee by using the adapter’s target interface.
- The adapter translates the request sent by the client class into a request that the adaptee class is expecting.

Note: The adaptee is hidden from the client by the wrapping adapter class.
 */
