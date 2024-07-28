package com.behavioural.strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Laptop", 1000));
        cart.addItem(new Item("Mouse", 20));

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "12/25"));
        cart.checkout();

        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout();
    }
}