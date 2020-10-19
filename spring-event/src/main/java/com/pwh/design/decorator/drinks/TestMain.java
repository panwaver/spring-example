package com.pwh.design.decorator.drinks;

import com.pwh.design.decorator.drinks.base.AbstractBeverage;

/**
 * @author panweihua
 * @date: 2020/10/15 16:21
 */
public class TestMain {
    public static void main(String[] args) {
        AbstractBeverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+"$"+beverage.cost());

        AbstractBeverage beverage2 = new DarkRoast();
        beverage2= new Mocha(beverage2);
        beverage2= new Mocha(beverage2);
        beverage2= new Whip(beverage2);
        System.out.println(beverage2.getDescription()+"$"+beverage2.cost());

        AbstractBeverage beverage3 = new HouseBlend();
        beverage3= new Mocha(beverage3);
        beverage3= new Whip(beverage3);
        System.out.println(beverage3.getDescription()+"$"+beverage3.cost());

    }
}
