package com.pwh.jdk.lamda;

@FunctionalInterface
public interface ChooseCondition<T> {

    boolean choose(T t);
}
