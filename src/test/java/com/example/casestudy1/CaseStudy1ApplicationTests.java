package com.example.casestudy1;

import com.example.casestudy1.domain.dao.ProductRepository;
import com.example.casestudy1.domain.dto.PriceDTO;
import com.example.casestudy1.domain.dto.ProductDTO;
import com.example.casestudy1.domain.model.Price;
import com.example.casestudy1.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CaseStudy1ApplicationTests {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void testGetProductInfo_200() {

        Product saveProductInfo = productRepository.save(Product.builder().name("Hamer")
                                                                 .current_price(Price.builder()
                                                                                        .value(120)
                                                                                        .currency_code("USD")
                                                                                        .build())
                                                                 .build());
        ResponseEntity<ProductDTO> responseEntity = template.getForEntity(
                "/products/" + saveProductInfo.getId(), ProductDTO.class);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
        assertThat(responseEntity.getBody().getName()).isEqualTo("Hamer");
    }

    @Test
    void testPutProductInfo_200() {
        Product savedProduct = productRepository.save(Product.builder().name("Hamer")
                                                              .current_price(Price.builder()
                                                                                     .value(120)
                                                                                     .currency_code("USD")
                                                                                     .build())
                                                              .build());
        ResponseEntity<ProductDTO> productResponseentity =
                template.exchange("/products/put/", HttpMethod.PUT,
                                  new HttpEntity<>(ProductDTO.builder().id(savedProduct.getId())
                                                           .name("Hamer")
                                                           .current_price(PriceDTO.builder()
                                                                                  .value(120)
                                                                                  .currency_code("USD")
                                                                                  .build())
                                                           .build()),
                                  ProductDTO.class);
        assertThat(productResponseentity.getBody()).isNotNull();
        assertThat(productResponseentity.getStatusCode().value()).isEqualTo(200);
        assertThat(productResponseentity.getBody().getId()).isEqualTo(savedProduct.getId());
        Product product = productRepository.findById(savedProduct.getId()).orElse(null);
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualToIgnoringCase("Hamer");
    }

}
