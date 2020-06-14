package com.practice.alg.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] testIntArray = new int[]{6,4,7,1,2};
        Arrays.stream(testIntArray).boxed()
                .forEach(element -> System.out.print(element + "\t"));
        for (int i = 0; i < testIntArray.length; i++) {
            int minPosition = i; //Assume starting element as minimum element
            for (int j = i; j < testIntArray.length; j++) { // Loop through rest of the elements & find out minimum element
                if (testIntArray[minPosition] > testIntArray[j]) {
                    minPosition = j;
                }
            }
            swapElements(testIntArray, i, minPosition);//swap elements in positions
        }
        Arrays.stream(testIntArray).boxed()
                .forEach(element -> System.out.print(element + "\t"));
    }

    private static void swapElements(int[] ints, int i, int minPosition) {
        int temp = ints[i];
        ints[i] = ints[minPosition];
        ints[minPosition] = temp;
    }
}
