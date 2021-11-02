package spacenews.api;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import spacenews.domain.Articles;
import spacenews.domain.ArticlesDeserializer;
import spacenews.domain.Providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class GetNews {
    ClassLoader classLoader = getClass().getClassLoader();
    public static void main(String[] args) {
        try {


            GetNews getNews = new GetNews();

            File file = new File(getNews.classLoader.getResource("articles.json").getFile());
            InputStream input = new FileInputStream(file);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            SimpleModule module = new SimpleModule();
            module.addDeserializer(Articles.class, new ArticlesDeserializer());
            objectMapper.registerModule(module);

           /* JsonNode node = objectMapper.readValue(input, JsonNode.class);
            JsonNode launchesNode = node.get("launches");
            JsonNode eventsNode = node.get("events");
//            ObjectMapper objectMapper = new ObjectMapper();
//        Providers provider = objectMapper.treeToValue(launchesNode.asText());
            if (launchesNode != null) {
                String id = launchesNode.get("id").asText();
                String provider = launchesNode.get("provider").asText();
                return new Providers(id,provider);
            }
            if (eventsNode != null) {
                String id = eventsNode.get("id").asText();
                String provider = eventsNode.get("provider").asText();
                return new Providers(id,provider);
            }*/


//            JsonNode jsonNode = objectMapper.readValue(input, JsonNode.class);
//            JsonNode launchesNode = jsonNode.get("launches");
//            JsonNode eventsNode = jsonNode.get("events");
//            JsonNode launchesNode = objectMapper.readTree(input);
//            Providers launches = objectMapper.treeToValue(launchesNode);

//            Articles[] cars2 = objectMapper.readValue(input, Articles[].class);
            List<Articles> articles = objectMapper.readValue(input, new TypeReference<List<Articles>>(){});
            System.out.println(articles.size());
            System.out.println(articles.get(0).getLaunches().getProvider());





        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}