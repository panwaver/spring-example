package com.pwh.design.decorator.drinks;

import com.pwh.design.decorator.drinks.base.AbstractBeverage;

/**
 * @author panweihua
 * @date: 2020/10/15 16:02
 */
public class HouseBlend extends AbstractBeverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
