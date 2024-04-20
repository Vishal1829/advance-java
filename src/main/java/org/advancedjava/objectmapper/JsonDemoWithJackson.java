package org.advancedjava.objectmapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonDemoWithJackson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        BankAccount bankAccount = new BankAccount(123, "Vishal");
        try {
            objectMapper.writeValue(new File("src/main/resources/bank-account-1.json"), bankAccount);
            //writeValueAsString generates a json from a java object and returns the json as a string.
            String asString = objectMapper.writeValueAsString(bankAccount);
            System.out.println(asString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //using readValue we can read a json string, file and parse it to a java object.
        String jsonString =
                """
                    {
                          "id": 123,
                          "holderName": "Vishal"
                    }
                """;
        try {
            BankAccount ba = objectMapper.readValue(jsonString, BankAccount.class);
            BankAccount ba1 = objectMapper.readValue(new File("src/main/resources/bank-account-1.json"), BankAccount.class);
            BankAccount ba2 = objectMapper.readValue(new URL("file:src/main/resources/bank-account-1.json"), BankAccount.class);
            System.out.println(ba);
            System.out.println(ba1);
            System.out.println(ba2);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //a json can be parsed into a JsonNode object representing a root of a json tree and this root can be used to
        //retrieve data from a specific node

        String json =
                """
                    {
                          "id": 123,
                          "holderName": "Vishal"
                    }
                """;
        try {
            JsonNode jsonRootNode = objectMapper.readTree(json);
            System.out.println(jsonRootNode.get("holderName").asText());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Parsing into an Array
        String jsonArray =
                """
                [
                   {
                      "id": 123,
                      "holderName": "Vishal"
                   },
                   {
                      "id": 124,
                      "holderName": "Lakshay"
                   },
                   {
                      "id": 125,
                      "holderName": "Raushan"
                   }
                ]
                """;
        try {
            objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
            BankAccount[] accounts = objectMapper.readValue(jsonArray, BankAccount[].class);
            Arrays.stream(accounts).forEach(System.out::println);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Parsing into a List
        try {
            List<BankAccount> bankAccounts = objectMapper.readValue(jsonArray, new TypeReference<List<BankAccount>>() {});
            bankAccounts.forEach(System.out::println);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Parsing into a Map
        String jsonToMap =
                """
                    {
                          "id": 123,
                          "holderName": "Vishal"
                    }
                """;
        try {
            Map<String, Object> stringObjectMap = objectMapper.readValue(jsonToMap, new TypeReference<Map<String, Object>>(){});
            System.out.println(stringObjectMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Customizations
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BankAccount ba = objectMapper.readValue(jsonString, BankAccount.class);
            JsonNode jsonRootNode = objectMapper.readTree(jsonString);
            JsonNode jsonNode = jsonRootNode.get("joinDate");
//            String joinDate = jsonNode.asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        //Using custom serializer
        SimpleModule serializerModule = new SimpleModule("CustomSerializer",
                                                          new Version(1, 0, 0, null, null, null));
        serializerModule.addSerializer(new CustomSerializer(BankAccount.class));
        objectMapper.registerModule(serializerModule);
        BankAccount account = new BankAccount(11, "Avinash");
        try {
            String accountJson = objectMapper.writeValueAsString(account);
            System.out.println(accountJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

//custom json serializer class
class CustomSerializer extends StdSerializer<BankAccount> {

    public CustomSerializer(Class<BankAccount> clazz) {
        super(clazz);
    }

    @Override
    public void serialize(BankAccount bankAccount, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("holderName", bankAccount.getHolderName());
        jsonGenerator.writeEndObject();
    }

}

/*
Brackets are used to represent a list or an array in json.
Note:- Any json string can be parsed into a Map<String, Object> as its essentially a key-value pair but parsing it will give
 an identity.

"""
[
   {
      "id": 123,
      "name": "Vishal",
      "age": 25
   },
   {
      "id": 124,
      "name": "Lakshay",
      "age": 26
   },
   {
      "id": 125,
      "name": "Raushan",
      "age": 27
   },
]
"""

Custom Serializers and Deserializers:-
useful in situations where the input or the output JSON response is different in structure than the Java class into
which it must be serialized or deserialized.
 */
