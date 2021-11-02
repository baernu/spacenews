package spacenews.domain;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ArticlesDeserializer extends StdDeserializer<Articles> {


    public ArticlesDeserializer() {
        this(null);
    }

    public ArticlesDeserializer(Class<?> vc) {
        super(vc);
    }

      @Override
    public Articles deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        String id = node.get("id").asText();
        String title = node.get("title").asText();
        String url = node.get("url").asText();
        String imageUrl = node.get("imageUrl").asText();
        String newsSite = node.get("newsSite").asText();
        String summary = node.get("summary").asText();
        String publishedAt = node.get("publishedAt").asText();
        String updatedAt = node.get("updatedAt").asText();
        String featured = node.get("featured").asText();
        JsonNode launchesNode = node.get("launches");
//        JsonNode launchesId = launchesNode.findPath("id");
//        JsonNode launchesProvider = launchesNode.findPath("provider");

        JsonNode eventsNode = node.get("events");
        Providers launches = null;
        Providers events = null;
        if (launchesNode.findPath("id") != null) {
            String idl = launchesNode.findPath("id").asText();
            String provider = launchesNode.findPath("provider").asText();
            launches = new Providers(idl,provider);

        }
        if (eventsNode.findPath("id") != null) {
            String ide = eventsNode.findPath("id").asText();
            String provider = eventsNode.findPath("provider").asText();
            events = new Providers(ide, provider);
        }



        return new Articles(id, title, url, imageUrl, newsSite, summary, publishedAt, updatedAt, featured, launches, events);

    }

}
