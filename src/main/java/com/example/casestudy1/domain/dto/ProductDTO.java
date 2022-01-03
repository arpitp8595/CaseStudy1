package com.example.casestudy1.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ProductDTO {

    @Setter
    private String id;
    private String name;
    private PriceDTO current_price;
}
