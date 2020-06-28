package com.practice.alg;

import java.util.Arrays;

/**
 * input [1234] + 1
 * output [1235]
 */
public class IncrementingArray {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 9, 9};
        incrementByCounter(inputArray, 100);
        Arrays.stream(inputArray).forEach(System.out::print);
        System.out.println();
        incrementUsingLoop(inputArray, 11);
        Arrays.stream(inputArray).forEach(System.out::print);
        System.out.println();
    }

    public static void incrementByCounter(int[] inputArray, int additionValue) {
        while (additionValue > 0) {
            incrementByOneUsingRecursion(inputArray, inputArray.length - 1);
            additionValue--;
        }
    }

    public static void incrementByOneUsingRecursion(int[] inputArray, int position) {
        int pickedElement = inputArray[position];
        if (pickedElement == 9) {
            inputArray[position] = 0;
            incrementByOneUsingRecursion(inputArray, position - 1);
        } else {
            inputArray[position] = pickedElement + 1;
        }
    }

    public static void incrementUsingLoop(int[] inputArray, int additionValue) {
        int i = inputArray.length - 1;
        int dividend = additionValue;
        for (; i >= 0; i--) {
            int pickedElement = inputArray[i];
            pickedElement += dividend;
            inputArray[i] = pickedElement % 10;
            dividend = pickedElement / 10;
            if (dividend <= 0) break;
        }
    }
}
