package com.pwh.design.decorator.drinks;

import com.pwh.design.decorator.drinks.base.AbstractBeverage;
import com.pwh.design.decorator.drinks.base.AbstractCondimentDecorator;

/**
 * @author panweihua
 * @date: 2020/10/15 16:15
 */
public class Mocha extends AbstractCondimentDecorator {
    AbstractBeverage beverage;

    public Mocha(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return 2.0 + beverage.cost();
    }
}
