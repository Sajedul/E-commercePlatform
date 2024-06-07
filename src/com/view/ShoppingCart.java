package com.view;

import com.model.Product;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> cart;

    public ShoppingCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
    public void addProduct(Product product) {
        cart.add(product);
    }
    public void removeProduct(String productId) {
        cart.removeIf(product -> product.getId().equals(productId));
    }
    public void viewCart() {
        for (Product product : cart) {
            System.out.println(product);
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }
}
