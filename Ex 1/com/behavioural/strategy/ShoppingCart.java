package com.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        if (paymentStrategy != null) {
            paymentStrategy.pay(total);
        } else {
            System.out.println("No payment strategy set");
        }
    }
}