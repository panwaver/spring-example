package com.pwh.jdk.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Choose {

    public static List<Fruit> chooseFruit4(List<Fruit> fruitList,
                                           ChooseCondition<Fruit> condition) {
        List<Fruit> result = new ArrayList<Fruit>();
        for (Fruit fruit : fruitList) {
            if (condition.choose(fruit)) {
                result.add(fruit);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        List<Fruit> fruitList = Arrays.asList(new Fruit(1.0, "red"), new Fruit(
                3.0, "red"), new Fruit(2.0, "red"), new Fruit(4.0, "yellow"));
        // 调用方法
        List<Fruit> result41 = chooseFruit4(fruitList, new ChooseCondition<Fruit>() {
            @Override
            public boolean choose(Fruit t) {
                return t.getColor().equals("red");
            }
        });
        System.out.println(result41.toString());
        List<Fruit> result42 = chooseFruit4(fruitList, new ChooseCondition<Fruit>() {
            @Override
            public boolean choose(Fruit t) {
                return t.getWeight() > 2.0;
            }
        });
        System.out.println(result42.toString());

        List<Fruit> fruits = chooseFruit4(fruitList, f -> f.getWeight() > 2.0);
        System.out.println(fruits);

        Iterator<Fruit> iterator = fruitList.iterator();
//        while (iterator.hasNext()){
//            if
//        }


    }

}
