package com.example.casestudy1.controller.product;

import com.example.casestudy1.domain.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        log.info("Retrieving data with Product Id: "+productId);
        ProductDTO product = productService.getProduct(productId);
        log.info("GET operation successful.!");
        return product;
    }

    @PutMapping(value = "/put")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        log.info("Retrieving data with Product Id: "+productDTO.getId());
        ProductDTO product = productService.updateProduct(productDTO.getId(), productDTO);
        log.info("UPDATE operation Successful with Request Body: " + product);
        return product;
    }

    @PostMapping("/saveProduct")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO product = productService.saveProduct(productDTO);
        log.info("SAVE operation successful with Request Body: " + product.toString());
        return product;
    }

    //400
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handleEmployeeException(IllegalStateException exception) {
        log.error("Error Product Exception: " + exception.getMessage(), exception);
        return exception.getMessage();
    }

}
