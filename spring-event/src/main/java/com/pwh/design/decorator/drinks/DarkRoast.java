package com.pwh.design.decorator.drinks;

import com.pwh.design.decorator.drinks.base.AbstractBeverage;

/**
 * 浓缩咖啡
 *
 * @author panweihua
 * @date: 2020/10/15 15:54
 */
public class DarkRoast extends AbstractBeverage {
    public DarkRoast() {
        description = "DarkRoast Coffee";
    }

    @Override
    public double cost() {
        return 1.98;
    }
}

