package spacenews.domain;



import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Articles {

    private String id;

    private String title;

    private String url;

    private String imageUrl;

    private String newsSite;

    private String summary;

    private String publishedAt;

    private String updatedAt;

    private String featured;

    private Providers launches;

    private Providers events;


     @JsonCreator
     public Articles(
             @JsonProperty("id")  String id,
             @JsonProperty("title") String title,
             @JsonProperty("url") String url,
             @JsonProperty("imageUrl")  String imageUrl,
             @JsonProperty("newsSite") String newsSite,
             @JsonProperty("summary") String summary,
             @JsonProperty("publishedAt")  String publishedAt,
             @JsonProperty("updatedAt") String updatedAt,
             @JsonProperty("featured") String featured,
             @JsonProperty("launches")  Providers launches,
             @JsonProperty("events") Providers events

     ) {



         this.id = id;
         this.title = title;
         this.url = url;
         this.imageUrl = imageUrl;
         this.newsSite = newsSite;
         this.summary = summary;
         this.publishedAt = publishedAt;
         this.updatedAt = updatedAt;
         this.featured = featured;
         this.launches = launches;
         this.events = events;

     }
    @JsonCreator
    public Articles(
            @JsonProperty("id")  String id,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url,
            @JsonProperty("imageUrl")  String imageUrl,
            @JsonProperty("newsSite") String newsSite,
            @JsonProperty("summary") String summary,
            @JsonProperty("publishedAt")  String publishedAt,
            @JsonProperty("updatedAt") String updatedAt,
            @JsonProperty("launches")  Providers launches,
            @JsonProperty("events") Providers events

    ) {



        this.id = id;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.newsSite = newsSite;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.launches = launches;
        this.events = events;

    }
    @JsonCreator
    public Articles(
            @JsonProperty("id")  String id,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url,
            @JsonProperty("imageUrl")  String imageUrl,
            @JsonProperty("newsSite") String newsSite,
            @JsonProperty("summary") String summary,
            @JsonProperty("publishedAt")  String publishedAt,
            @JsonProperty("updatedAt") String updatedAt


    ) {



        this.id = id;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.newsSite = newsSite;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;

    }



    @JsonGetter("id")
    public String getId() {
        return id;
    }
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }
    @JsonGetter("url")
    public String getUrl() {
        return url;
    }
    @JsonGetter("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }
    @JsonGetter("newSite")
    public String getNewsSite() {
        return newsSite;
    }
    @JsonGetter("summary")
    public String getSummary() {
        return summary;
    }
    @JsonGetter("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }
    @JsonGetter("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }
    @JsonGetter("featured")
    public String getFeatured() {
        return featured;
    }
    @JsonGetter("launches")
    public Providers getLaunches() {
        return launches;
    }
    @JsonGetter("events")
    public Providers getEvents() {
        return events;
    }


}