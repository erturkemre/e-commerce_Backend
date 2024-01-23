package com.work.e_commerce.converter;

import com.work.e_commerce.dto.OrderResponse;
import com.work.e_commerce.dto.ProductResponse;
import com.work.e_commerce.dto.RoleResponse;
import com.work.e_commerce.dto.UserResponse;
import com.work.e_commerce.entity.Order;
import com.work.e_commerce.entity.Product;
import com.work.e_commerce.entity.Role;
import com.work.e_commerce.entity.User;


import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static List<UserResponse> convertToUserResponseList(List<User> users){
        List<UserResponse> responses = new ArrayList<>();
        users.forEach(user ->{
            responses.add(new UserResponse(user.getId(), user.getName(),user.getEmail(), user.getRoles()));
        });
        return responses;
    }

    public static UserResponse convertToResponse(User user){
        return new UserResponse(user.getId(), user.getName(),user.getEmail(), user.getRoles());
    }

    //RoleConvertor
    public static List<RoleResponse> convertToRoleResponseList(List<Role> roles){
        List<RoleResponse> responses = new ArrayList<>();
        roles.forEach(role ->{
            responses.add(new RoleResponse(role.getId(), role.getRoleName() ,role.getStoreName(),role.getStorePhone(),role.getStoreTaxNum(),role.getIban()));
        });
        return responses;
    }
    public static RoleResponse convertToRoleResponse(Role role){
        return new RoleResponse(role.getId(), role.getRoleName(),role.getStoreName(),role.getStorePhone(),role.getStoreTaxNum(),role.getIban());
    }

    //ProductConvertor
    public static List<ProductResponse> convertToProductResponseList(List<Product> products){
        List<ProductResponse> responses = new ArrayList<>();
        products.forEach(product ->{
            responses.add(new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getStock(),product.getCategoryId(),product.getRating(),product.getSellCount(),product.getImages()));
        });
        return responses;
    }
    public static ProductResponse convertToProductResponse(Product product){
        return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getStock(),product.getCategoryId(),product.getRating(),product.getSellCount(),product.getImages());
    }

    //OrderConvertor
    public static List<OrderResponse> convertToOrderResponseList(List<Order> orders){
        List<OrderResponse> responses = new ArrayList<>();
        orders.forEach(order ->{
            responses.add(new OrderResponse(order.getId(),order.getCount(),order.getProductId(),order.getAddressId()));
        });
        return responses;
    }
    public static OrderResponse convertToOrderResponse(Order order){
        return new OrderResponse(order.getId(),order.getCount(),order.getProductId(),order.getAddressId());
    }
}
