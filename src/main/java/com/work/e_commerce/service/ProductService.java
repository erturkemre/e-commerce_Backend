package com.work.e_commerce.service;

import com.work.e_commerce.dto.ProductOrderResponse;
import com.work.e_commerce.dto.ProductResponse;
import com.work.e_commerce.entity.Product;

import java.util.List;


public interface ProductService {
    List<ProductResponse> findAll();

    ProductResponse save(Product product);

    Product findById(long id);

    ProductResponse remove(long id);

    ProductOrderResponse productAddToOrder(long productId, long orderId);
    List<ProductResponse> getFilteredAndSortedProducts(Integer limit, Integer offset, Long categoryId, String filter, String sort);
}