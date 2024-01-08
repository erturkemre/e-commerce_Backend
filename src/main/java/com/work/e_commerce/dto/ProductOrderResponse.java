package com.work.e_commerce.dto;

import java.util.List;

public record ProductOrderResponse(String name, String description,Double price,  int stock,
                                   Double rating,
                                   String images, List<OrderResponse> orderResponses) {
}
