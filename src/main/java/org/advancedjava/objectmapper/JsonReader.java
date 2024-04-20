package org.advancedjava.objectmapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonReader {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = null;
        try (InputStream inputStream = JsonReader.class.getResourceAsStream("/blog-posts.json")) {
            json = objectMapper.readValue(inputStream, JsonNode.class);
            System.out.println(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonNode edges = getEdges(json);
        edges.forEach(edge -> {
            posts.add(createPostFromNode(edge));
        });

        posts.forEach(post -> {
            System.out.println(post.toString());
        });

//        System.out.println("Hello");
    }

    private static Post createPostFromNode(JsonNode edge) {
        JsonNode node = edge.get("node");
        String id = node.get("id").asText();
        String title = node.get("title").asText();
        String slug = node.get("slug").asText();
        String date = node.get("date").asText();
        Integer timeToRead = node.get("timeToRead").asInt();
        String tags = extractTags(node);

        return new Post(id, title, slug, LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy")), timeToRead, tags);
    }

    private static String extractTags(JsonNode node) {
        JsonNode tags = node.get("tags");
        StringBuilder sb = new StringBuilder();
        tags.forEach(tag -> {
            sb.append(tag.get("title").asText());
            sb.append(",");
        });
        return sb.toString();
    }

    private static JsonNode getEdges(JsonNode json) {
        return Optional.ofNullable(json)
                .map(j -> j.get("data"))
                .map(j -> j.get("allPost"))
                .map(j -> j.get("edges"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid JSON Object"));
    }
}
