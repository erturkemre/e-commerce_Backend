package com.work.e_commerce.repository;

import com.work.e_commerce.dto.ProductResponse;
import com.work.e_commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p " +
            "WHERE (:categoryId IS NULL OR p.categoryId = :categoryId) " +
            "AND (:filter IS NULL OR LOWER(p.name) LIKE LOWER(concat('%', :filter, '%'))) " +
            "ORDER BY " +
            "CASE WHEN :sort = 'price:asc' THEN p.price END ASC, " +
            "CASE WHEN :sort = 'price:desc' THEN p.price END DESC, " +
            "CASE WHEN :sort = 'rating:asc' THEN p.rating END ASC, " +
            "CASE WHEN :sort = 'rating:desc' THEN p.rating END DESC " +
            "LIMIT :limit OFFSET :offset")
    List<Product> getFilteredAndSortedProducts(@Param("limit") Integer limit,
                                                       @Param("offset") Integer offset,
                                                       @Param("categoryId") Long categoryId,
                                                       @Param("filter") String filter,
                                                       @Param("sort") String sort);
}
