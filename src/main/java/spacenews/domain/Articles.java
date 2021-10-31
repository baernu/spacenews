package spacenews.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Articles {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("newsSite")
    private String newsSite;

    @JsonProperty("Summary")
    private String summary;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("featured")
    private String featured;

    @JsonProperty("Launches")
    private List<String> launches;

    @JsonProperty("events")
    private List<String> events;

    public Articles(String id, String title, String url, String imageUrl, String newsSite,
                    String summary, String publishedAt, String updatedAt, String featured,
                    List<String> launches, List<String> events) {
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


}