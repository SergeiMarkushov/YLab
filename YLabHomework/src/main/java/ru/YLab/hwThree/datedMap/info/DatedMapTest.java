package ru.YLab.hwThree.datedMap.info;

import java.awt.image.ImageProducer;

public class DatedMapTest {
    public static void main(String[] args) {
        DatedMap datedMap = new DatedMapImpl();

        datedMap.put("1", "One");
        datedMap.put("2", "Two");
        datedMap.put("3", "Tree");
        datedMap.put("4", "Four");

        System.out.println(datedMap.get("3"));
        System.out.println(datedMap.containsKey("2"));
        datedMap.remove("3");
        System.out.println(datedMap.keySet());
        System.out.println(datedMap.getKeyLastInsertionDate("1"));
    }
}
