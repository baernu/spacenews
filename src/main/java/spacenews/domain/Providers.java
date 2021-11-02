package spacenews.domain;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Providers {

    private String id;

    private String provider;

    @JsonCreator
    public Providers(
            @JsonProperty("id")  String id,
            @JsonProperty("provider") String provider  ) {

        this.id = id;
        this.provider = provider;
    }
    @JsonGetter("id")
    public String getId() {
        return id;
    }
    @JsonGetter("provider")
    public String getProvider() {
        return provider;
    }
    @JsonSetter("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonSetter("provider")
    public void setProvider(String provider) {
        this.provider = provider;
    }


}
