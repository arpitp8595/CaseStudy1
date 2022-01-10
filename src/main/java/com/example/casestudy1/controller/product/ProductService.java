package com.example.casestudy1.controller.product;

import com.example.casestudy1.domain.dao.ProductRepository;
import com.example.casestudy1.domain.dto.ProductDTO;
import com.example.casestudy1.domain.model.Product;
import com.example.casestudy1.domain.util.ProductSchemaConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProduct(String productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new IllegalStateException("Cannot find product with productId: " + productId);
        }
        log.info("Product Response: "+ ProductSchemaConverter.modelToSchema(productOptional.get()));
        return ProductSchemaConverter.modelToSchema(productOptional.get());
    }

    public ProductDTO updateProduct(String productId, ProductDTO productDTO) {
        log.info("Setting values with product Id: "+productId);
        productDTO.setId(productId);
        Product product = ProductSchemaConverter.schemaToModel(productDTO);
        productRepository.save(product);
        log.info("PUT operation Successful with productId: "+productId);
        return ProductSchemaConverter.modelToSchema(product);
    }

    public void saveProduct(ProductDTO productDTO) {
        Product product = ProductSchemaConverter.schemaToModel(productDTO);
        productRepository.save(product);
    }

}
