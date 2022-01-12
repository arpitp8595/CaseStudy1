package com.example.casestudy1.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Builder
public class Product {
    @Id private String id;
    private String name;
    private Price current_price;

    public void updatePriceForWithValue(Price changedPrice) {
        verifyPricesBusinessRules(changedPrice);
        this.current_price = changedPrice;
    }

    public void verifyPricesBusinessRules(Price price) {
        //business rule
        if(price.getValue() < 0) {
            throw new IllegalStateException("Product price can't be less than zero.");
        }
        //business rule
        if(!"USD".equalsIgnoreCase(price.getCurrency_code())) {
            throw new IllegalStateException("Product currency needs to be USD.");
        }
    }

}
