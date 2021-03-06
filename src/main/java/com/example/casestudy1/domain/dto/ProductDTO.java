package com.example.casestudy1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class ProductDTO {

    @Setter
    private String id;
    private String name;
    private PriceDTO current_price;

}


