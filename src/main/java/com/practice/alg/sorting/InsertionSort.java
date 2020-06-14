package com.practice.alg.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] testIntArray = new int[]{6,4,7,1,2,12,3,42,324,23,0};
        Arrays.stream(testIntArray).boxed()
                .forEach(element -> System.out.print(element + "\t"));
        System.out.println();
        for (int i = 0; i < testIntArray.length; i++) {
            int selectedPosition = i; //Get current picked element position
            for (int j = i; j >= 0; j--) { // Loop back from the selected element position and find out proper place
               if (testIntArray[j] > testIntArray[i]) {
                   selectedPosition = j;
               }
            }
            if (i > selectedPosition) {
                int selectedElement = testIntArray[i];// store selected element
                shiftPositionsByOne(testIntArray, selectedPosition, i); // move elements one position at a time
                testIntArray[selectedPosition] = selectedElement;//put element to the selected position
            }
        }

        Arrays.stream(testIntArray).boxed()
                .forEach(element -> System.out.print(element + "\t"));
    }

    private static void shiftPositionsByOne(int[] ints, int startingPosition, int endingPosition) {

        for (int i = endingPosition; i > startingPosition; i--) {
            ints[endingPosition] = ints[endingPosition-1];
            endingPosition--;
        }
    }

}
