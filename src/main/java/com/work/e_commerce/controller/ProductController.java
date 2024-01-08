package com.work.e_commerce.controller;

import com.work.e_commerce.dto.ProductOrderResponse;
import com.work.e_commerce.dto.ProductResponse;
import com.work.e_commerce.entity.Product;
import com.work.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public ProductResponse save(@RequestBody Product product){
        return productService.save(product);
    }

    @PostMapping("/{productId}/add-to-order/{orderId}")
    public ResponseEntity<ProductOrderResponse> addProductToOrder(@PathVariable long productId, @PathVariable long orderId) {
        try {
            ProductOrderResponse response = productService.productAddToOrder(productId, orderId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/")
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<ProductResponse>> getProducts(@RequestParam(required = false) Integer limit,
                                                     @RequestParam(required = false) Integer offset,
                                                     @RequestParam(required = false) Long category,
                                                     @RequestParam(required = false) String filter,
                                                     @RequestParam(required = false) String sort) {
        List<ProductResponse> products = productService.getFilteredAndSortedProducts(limit, offset, category, filter, sort);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable long id){
        Product product = productService.findById(id);
        return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getStock(),product.getCategoryId(),product.getRating(),product.getSellCount(),product.getImages());
    }
    @DeleteMapping("/{id}")
    public ProductResponse deleteById(@PathVariable long id){
        return productService.remove(id);
    }
}
