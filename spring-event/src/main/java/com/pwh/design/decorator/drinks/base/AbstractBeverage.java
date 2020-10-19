package com.pwh.design.decorator.drinks.base;

/**
 * 装饰模式demo
 *
 * @author panweihua
 * @date: 2020/10/15 15:50
 */
public abstract class AbstractBeverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
