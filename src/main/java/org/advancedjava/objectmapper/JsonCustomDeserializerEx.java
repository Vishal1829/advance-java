package org.advancedjava.objectmapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

public class JsonCustomDeserializerEx {
    public static void main(String[] args) {
        String jsonCustom =
                """
                    {
                          "id": 123,
                          "holderName": "Vishal"
                    }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule deserializerModule = new SimpleModule("CustomDeserializer",
                new Version(1, 0, 0, null, null, null));
        deserializerModule.addDeserializer(BankAccount.class, new CustomSerializerDemo(BankAccount.class));
        objectMapper.registerModule(deserializerModule);
        try {
            BankAccount acc = objectMapper.readValue(jsonCustom, BankAccount.class);
            System.out.println(acc);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

//custom json serializer class
class CustomSerializerDemo extends StdDeserializer<BankAccount> {

    public CustomSerializerDemo(Class<BankAccount> clazz) {
        super(clazz);
    }

    @Override
    public BankAccount deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        BankAccount bankAccount = new BankAccount();
        JsonNode node = parser.getCodec().readTree(parser);
        String holderName = node.get("holderName").asText();
        bankAccount.setHolderName(holderName);
        return bankAccount;
    }
}
