package com.example.internshipproject.service;

import com.example.internshipproject.model.Product;
import com.example.internshipproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product fetchProductDetails() {
        return productRepository.findById(1L).orElse(null);
    }

    @Override
    public Map<String, Integer> fetchCoupons() {
        Map<String, Integer> coupons = new HashMap<>();
        coupons.put("OFF5", 5);
        coupons.put("OFF10", 10);
        return coupons;
    }

    @Override
    public String placeOrder(Long userId, int quantity, String couponCode) {
        Product product = fetchProductDetails();
        if (product == null) {
            return "Product not found!";
        }
        if (quantity < 1 || quantity > product.getAvailableQuantity()) {
            return "Invalid quantity!";
        }
        Map<String, Integer> availableCoupons = fetchCoupons();
        int discount = 0;
        if (availableCoupons.containsKey(couponCode)) {
            discount = availableCoupons.get(couponCode);
        } else {
            return "Invalid coupon!";
        }
        double price = product.getPrice().doubleValue();
        double discountedPrice = price * (100 - discount) / 100;
        double amount = discountedPrice * quantity;
        return "Order placed successfully! Amount to pay: " + amount;
    }
}
