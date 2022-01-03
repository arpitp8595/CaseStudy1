package com.example.casestudy1.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceDTO {
    private int value;
    private String currency_code;
}
