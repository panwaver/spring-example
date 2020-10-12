package com.pwh.jdk.lamda;

public class Fruit {
//    private String name;
    private Double weight;
    private String color;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


    public Fruit() {
    }

    public Fruit(Double weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
