package sk.stuba.fei.uim.oop.assignment3.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProductNameDescriptionRequest {
    private String name;
    private String description;
    public ProductNameDescriptionRequest(@JsonProperty("name") String name, @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }
}
