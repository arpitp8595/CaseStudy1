package com.example.casestudy1.controller.product;

import com.example.casestudy1.domain.dao.ProductRepository;
import com.example.casestudy1.domain.dto.ProductDTO;
import com.example.casestudy1.domain.model.Product;
import com.example.casestudy1.domain.util.ProductSchemaConverter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProduct(String productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new IllegalStateException("Cannot find product with productId: " + productId);
        }
        return ProductSchemaConverter.modelToSchema(productOptional.get());
    }

    public ProductDTO updateProduct(String productId, ProductDTO productDTO) {
        productDTO.setId(productId);
        Product product = ProductSchemaConverter.schemaToModel(productDTO);
        productRepository.save(product);
        return ProductSchemaConverter.modelToSchema(product);
    }
}
