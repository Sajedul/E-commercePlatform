package com.service;

import com.view.ShoppingCart;

public class Order {
    private ShoppingCart cart;
    private String customerName;
    private String customerAddress;

    public Order(ShoppingCart cart, String customerName, String customerAddress) {
        this.cart = cart;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }
    public void placeOrder() {
        // Here, we would implement the logic to process the order
        System.out.println("Order placed by " + customerName + " to be shipped to " + customerAddress);
        System.out.println("Order details:");
        cart.viewCart();
        System.out.println("Total: " + cart.getTotal());
    }
}
