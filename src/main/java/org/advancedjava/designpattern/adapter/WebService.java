package org.advancedjava.designpattern.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebService {
    private final String webHost;

    public WebService(String webHost) {
        this.webHost = webHost;
    }

    public JsonNode request(final String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, JsonNode.class);
    }
}
