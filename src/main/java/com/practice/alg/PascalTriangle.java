package com.practice.alg;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] s) {
        PascalTriangle triangle =  new PascalTriangle();
        triangle.pascal(5);
    }
    public void pascal(int level) {
        List<List<Integer>> totalElements = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        totalElements.add(newList(elements));
        elements.add(1);
        totalElements.add(newList(elements));
        System.out.println(totalElements);
        for(int i = 2; i<level; i++) {
            List<Integer> tempList = new ArrayList<>();

            for (int j = 0 ; j <= i; j++) {
                if (j == 0 || j == i ) {
                    tempList.add(1);
                } else {
                    tempList.add( elements.get(j) + elements.get(j-1));
                }
            }
            elements=tempList;
            totalElements.add(newList(tempList));

        }
        System.out.println(totalElements);
    }

    private List<Integer> newList(List<Integer> elements) {
        return new ArrayList<>(elements);
    }
}
