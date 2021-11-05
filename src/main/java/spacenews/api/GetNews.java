package spacenews.api;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.scene.layout.HBox;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import spacenews.domain.Articles;
import spacenews.domain.ArticlesDeserializer;
import spacenews.domain.NewsType;
import spacenews.domain.Providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetNews {

    private List<Articles> articles = new ArrayList<>();




    public void load(NewsType newsType) {

        String input = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response;
        HttpGet request = null;
        try {
            switch (newsType) {
                case Article -> request = new HttpGet("https://api.spaceflightnewsapi.net/v3/articles");
                case Blog -> request = new HttpGet("https://api.spaceflightnewsapi.net/v3/blogs");
                case Report -> request = new HttpGet("https://api.spaceflightnewsapi.net/v3/reports");
            }


            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                input = EntityUtils.toString(entity);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();

        }
        try {


            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            SimpleModule module = new SimpleModule();
            module.addDeserializer(Articles.class, new ArticlesDeserializer());
            objectMapper.registerModule(module);

            articles = objectMapper.readValue(input, new TypeReference<List<Articles>>(){});


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public List<Articles> getArticles() {
        return this.articles;
    }

}