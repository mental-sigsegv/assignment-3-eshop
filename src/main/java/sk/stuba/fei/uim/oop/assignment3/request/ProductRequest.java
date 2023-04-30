package sk.stuba.fei.uim.oop.assignment3.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long amount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String unit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double price;
}
