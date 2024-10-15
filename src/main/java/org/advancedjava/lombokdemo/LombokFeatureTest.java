package org.advancedjava.lombokdemo;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class LombokFeatureTest {

    //now here for this method we have to either throw the exception or add try-catch block to handle
    //it as it is a checked exception.
    //so instead of doing all this we can ask lombok to do it for us using @SneakyThrows
    //it will add try catch block if we use this annotation and inside catch it will throw exception.
    @SneakyThrows
    public String byteArrayToString(byte[] bytes) {
        return new String(bytes, "UTF8");
    }


    public void readFile() throws IOException {
        // Use @Cleanup to ensure resources are closed automatically
        @Cleanup FileInputStream fileInputStream = new FileInputStream("data.txt");
        @Cleanup BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            // Print the line from the file
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.format(new Date()));

        Stream.of("Hello", "World").map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
/*
@SneakyThrows:
This annotation is used on the method. You can wrap the code in the method with try-catch statement,
catch the exception and throw it in the catch with Lombok.sneakyThrow(e). You can use
@SneakyThrows(Exception.class) to specify which exception to throw.
 */
