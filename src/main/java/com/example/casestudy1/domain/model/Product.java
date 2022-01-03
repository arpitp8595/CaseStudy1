package com.example.casestudy1.domain.model;

import lombok.AllArgsConstructor;
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
}
