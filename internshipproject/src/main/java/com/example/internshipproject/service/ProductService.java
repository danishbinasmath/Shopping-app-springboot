package com.example.internshipproject.service;

import com.example.internshipproject.model.Product;

import java.util.Map;

public interface ProductService {
    Product fetchProductDetails();
    Map<String, Integer> fetchCoupons(); // Add this method
    String placeOrder(Long userId, int quantity, String couponCode);
}
