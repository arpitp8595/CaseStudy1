package com.example.casestudy1.controller.product;

import com.example.casestudy1.domain.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{productId}")
    public ProductDTO getProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    @PutMapping(value = "/{productId}")
    public ProductDTO updateProduct(@PathVariable String productId, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productId, productDTO);
    }

    //400
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handleEmployeeException(IllegalStateException exception) {
        log.error("Error EmployeeException: " + exception.getMessage(), exception);
        return exception.getMessage();
    }


}