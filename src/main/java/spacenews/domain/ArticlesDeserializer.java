package spacenews.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticlesDeserializer extends StdDeserializer<Articles> {


    public ArticlesDeserializer() {
        this(null);
    }

    public ArticlesDeserializer(Class<?> vc) {
        super(vc);
    }

      @Override
    public Articles deserialize(JsonParser jp, DeserializationContext ctxt)  {
        try {
            String featured = null;
            JsonNode launchesNode = null;
            JsonNode eventsNode = null;
            JsonNode node = jp.getCodec().readTree(jp);
            String id = node.get("id").asText();
            String title = node.get("title").asText();
            String url = node.get("url").asText();
            String imageUrl = node.get("imageUrl").asText();
            String newsSite = node.get("newsSite").asText();
            String summary = node.get("summary").asText();
            String publishedAt = node.get("publishedAt").asText();
            String updatedAt = node.get("updatedAt").asText();
            if (node.get("featured") != null) {
                featured = node.get("featured").asText();
            }
            if (node.get("launches") != null) {
                launchesNode = node.get("launches");
            }

            if (node.get("events") != null) {
                eventsNode = node.get("events");
            }

            Providers launches = null;
            Providers events = null;
            if (launchesNode != null) {
                if (launchesNode.findPath("id") != null) {
                    String idl = launchesNode.findPath("id").asText();
                    String provider = launchesNode.findPath("provider").asText();
                    launches = new Providers(idl, provider);
                }

            }
            if (eventsNode != null) {
                if (eventsNode.findPath("id") != null) {
                    String ide = eventsNode.findPath("id").asText();
                    String provider = eventsNode.findPath("provider").asText();
                    events = new Providers(ide, provider);
                }
            }


            if (featured != null) {
                return new Articles(id, title, url, imageUrl, newsSite, summary, publishedAt, updatedAt, featured, launches, events);
            }
            if (featured == null && launches != null) {
                return new Articles(id, title, url, imageUrl, newsSite, summary, publishedAt, updatedAt, launches, events);
            }
            if (launches == null) {
                return new Articles(id, title, url, imageUrl, newsSite, summary, publishedAt, updatedAt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }

}
