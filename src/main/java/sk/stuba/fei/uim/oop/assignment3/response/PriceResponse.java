package sk.stuba.fei.uim.oop.assignment3.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PriceResponse {
    private Double price;
    public PriceResponse(Double price) {
        this.price = price;
    }
}
