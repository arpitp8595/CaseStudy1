package com.example.casestudy1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Builder
public class Price {
    private int value;
    private String currency_code;
}
