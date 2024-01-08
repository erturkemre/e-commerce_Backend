package com.work.e_commerce.dto;

import jakarta.persistence.Column;

public record ProductResponse(long id,String name, String description,Double price, int stock, int categoryId,
         Double rating,
         int sellCount,
         String images) {
}
