package sk.stuba.fei.uim.oop.assignment3.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProductNameDescriptionRequest {
    private final String name;
    private final String description;
    public ProductNameDescriptionRequest(@JsonProperty("name") String name, @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }
}
