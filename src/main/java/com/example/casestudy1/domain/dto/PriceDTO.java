package com.example.casestudy1.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class PriceDTO {
    private int value;
    private String currency_code;
}
