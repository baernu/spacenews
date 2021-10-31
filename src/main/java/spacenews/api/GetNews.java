package spacenews.api;



import com.fasterxml.jackson.databind.ObjectMapper;
import spacenews.domain.Articles;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class GetNews {
    ClassLoader classLoader = getClass().getClassLoader();
    public static void main(String[] args) {
        try {

            GetNews getNews = new GetNews();

            File file = new File(getNews.classLoader.getResource("articles.json").getFile());
            InputStream input = new FileInputStream(file);
            ObjectMapper objectMapper = new ObjectMapper();
            Articles[] cars2 = objectMapper.readValue(input, Articles[].class);




        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}