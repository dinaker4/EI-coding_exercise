package com.structural.decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " costs $" + coffee.getCost());

        Coffee coffeeWithMilk = new Milk(coffee);
        System.out.println(coffeeWithMilk.getDescription() + " costs $" + coffeeWithMilk.getCost());

        Coffee coffeeWithMilkAndSugar = new Sugar(new Milk(coffee));
        System.out.println(coffeeWithMilkAndSugar.getDescription() + " costs $" + coffeeWithMilkAndSugar.getCost());

        Coffee deluxeCoffee = new Whip(new Sugar(new Milk(new SimpleCoffee())));
        System.out.println(deluxeCoffee.getDescription() + " costs $" + deluxeCoffee.getCost());
    }
}