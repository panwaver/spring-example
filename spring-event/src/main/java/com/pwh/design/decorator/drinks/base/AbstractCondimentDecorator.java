package com.pwh.design.decorator.drinks.base;

/**
 * 调料
 *
 * @author panweihua
 * @date: 2020/10/15 16:11
 */
public abstract class AbstractCondimentDecorator extends AbstractBeverage {
    @Override
    public abstract String getDescription();
}
