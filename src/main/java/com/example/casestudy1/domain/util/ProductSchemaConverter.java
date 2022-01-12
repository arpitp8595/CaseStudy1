package com.example.casestudy1.domain.util;

import com.example.casestudy1.domain.dto.PriceDTO;
import com.example.casestudy1.domain.dto.ProductDTO;
import com.example.casestudy1.domain.model.Price;
import com.example.casestudy1.domain.model.Product;

public class ProductSchemaConverter {

    public static ProductDTO modelToSchema(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .current_price(PriceDTO.builder()
                        .value(product.getCurrent_price().getValue())
                        .currency_code(product.getCurrent_price().getCurrency_code())
                        .build())
                .build();
    }

    public static Product schemaToModel(ProductDTO productDTO) {
        return Product.builder()
                //id(productDTO.getId())
                .name(productDTO.getName())
                .current_price(Price.builder()
                        .value(productDTO.getCurrent_price().getValue())
                        .currency_code(productDTO.getCurrent_price().getCurrency_code())
                        .build())
                .build();
    }

}
