package org.advancedjava.designpattern.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebAdapter implements WebRequester {
    private WebService service;
    public void connect(WebService currentService) {
        this.service = currentService;
    }
    @Override
    public int request(Object request) {
        String json;
        try {
            json = new ObjectMapper().writeValueAsString(request);
            log.info("converting request object to JSON - {}", json);
            JsonNode response = service.request(json);
            if (response != null) {
                log.info("JsonNode - {}", response);
                return 200; //OK status code
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return 500; //server error status code
    }
}
