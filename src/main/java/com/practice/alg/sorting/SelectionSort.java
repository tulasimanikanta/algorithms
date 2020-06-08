package com.practice.alg.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] ints = new int[]{6,4,7,1,2};
        Arrays.stream(ints).boxed().forEach(System.out::print);
        for (int i = 0; i < ints.length; i++) {
            int minPosition = i; //Assume starting element as minimum element
            for (int j = i; j < ints.length; j++) { // Loop through rest of the elements & find out minimum element
                if (ints[minPosition] > ints[j]) {
                    minPosition = j;
                }
            }
            swapElements(ints, i, minPosition);//swap elements in positions
        }
        Arrays.stream(ints).boxed().forEach(System.out::print);
    }

    private static void swapElements(int[] ints, int i, int minPosition) {
        int temp = ints[i];
        ints[i] = ints[minPosition];
        ints[minPosition] = temp;
    }
}
