package com.work.e_commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product", schema = "ecommercedb")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column (name = "price")
    private Double price;
    @Column(name = "stock")
    private int stock;
    @Column(name = "store_id")
    private int storeId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "sell_count")
    private int sellCount;
    @Column(name = "images")
    private String images;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "product_order",schema = "ecommercedb", joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    public void addOrder(Order order){
        if(orders == null){
            orders = new ArrayList<>();
        }
        orders.add(order);
    }


}
