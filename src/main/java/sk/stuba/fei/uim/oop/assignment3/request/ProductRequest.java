package sk.stuba.fei.uim.oop.assignment3.request;

import lombok.Getter;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
public class ProductRequest {
    private String name;
    private String description;
    public ProductRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
