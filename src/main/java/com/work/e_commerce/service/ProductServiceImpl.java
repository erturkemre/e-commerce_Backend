package com.work.e_commerce.service;

import com.work.e_commerce.converter.DtoConverter;
import com.work.e_commerce.dto.*;
import com.work.e_commerce.entity.Order;
import com.work.e_commerce.entity.Product;
import com.work.e_commerce.exception.ErrorException;
import com.work.e_commerce.repository.OrderRepository;
import com.work.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;
    OrderRepository orderRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }



    @Override
    public List<ProductResponse> findAll() {
        return DtoConverter.convertToProductResponseList(productRepository.findAll());
    }

    @Override
    public ProductResponse save(Product product) {
        return DtoConverter.convertToProductResponse(productRepository.save(product));
    }

    @Override
    public Product findById(long id) {
        Optional<Product> optionalProduct= productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return (optionalProduct.get());
        }
        throw new ErrorException("Product not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ProductResponse remove(long id) {
        Product willremove = findById(id);
        productRepository.delete(willremove);
        return DtoConverter.convertToProductResponse(willremove);
    }

    @Override
    public ProductOrderResponse productAddToOrder(long productId, long orderId) {
        Product product = productRepository.findById(productId).get();
        Order order = orderRepository.findById(orderId).get();

        product.addOrder(order);
        Product addedProduct = productRepository.save(product);

        List<OrderResponse> orderResponses = new ArrayList<>();
        for(Order order1:addedProduct.getOrders()){
            orderResponses.add(new OrderResponse(order1.getId(),order1.getProductId(),order1.getCount(),order1.getAddressId()));
        }


        return new ProductOrderResponse(product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getRating(),  product.getImages(),orderResponses);
    }

    @Override
    public List<ProductResponse> getFilteredAndSortedProducts(Integer limit, Integer offset, Long categoryId, String filter, String sort) {
        if (limit == null) {
            limit = 25;
        }
        if (offset == null) {
            offset = 0;
        }
        List<Product> products = productRepository.getFilteredAndSortedProducts(limit, offset, categoryId, filter, sort);
        return DtoConverter.convertToProductResponseList(products);
    }


}
