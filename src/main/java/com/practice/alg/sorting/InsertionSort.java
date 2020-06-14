package com.practice.alg.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] ints = new int[]{6,4,7,1,2};
        Arrays.stream(ints).boxed().forEach(System.out::print);
        System.out.println();
        for (int i = 0; i < ints.length; i++) {
            int selectedPosition = i; //Get current picked element position
            for (int j = i; j >= 0; j--) { // Loop back from the selected element position and find out proper place
               if (ints[j] > ints[i]) {
                   selectedPosition = j;
               }
            }
            if (i > selectedPosition) {
                int selectedElement = ints[i];// store selected element
                shiftPositionsByOne(ints, selectedPosition, i); // move elements one position at a time
                ints[selectedPosition] = selectedElement;//put element to the selected position
            }
        }

        Arrays.stream(ints).boxed().forEach(System.out::print);
    }

    private static void shiftPositionsByOne(int[] ints, int startingPosition, int endingPosition) {

        for (int i = endingPosition; i > startingPosition; i--) {
            ints[endingPosition] = ints[endingPosition-1];
            endingPosition--;
        }
    }

}
