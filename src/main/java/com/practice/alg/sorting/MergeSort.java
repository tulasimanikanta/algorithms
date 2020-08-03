package com.practice.alg.sorting;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSort {
    public static void main(String args[])
    {
        int arr[] = {16, 11, 13, 5, 6, 7};
        divide(arr, 0, arr.length-1);
        System.out.println();
        Arrays.stream(arr).boxed().forEach(System.out::print);

    }
    public static void divide(int[] src, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            divide(src, left, mid);
            divide(src, mid+1, right);
            mergeSort(src, left, mid, mid+1, right);
        }
    }

    public static void mergeSort(int[] src, int left, int leftLength, int right, int rightLength) {
        int[] tempArray = new int[rightLength-left+1];
        int tempInsertPosition = 0;
        int startingPos = left;

        while(left <= leftLength && right <= rightLength) {
           if (src[left] < src[right]) {
               tempArray[tempInsertPosition] = src[left];
               left++;
           } else {
               tempArray[tempInsertPosition] = src[right];
               right++;
           }
            tempInsertPosition++;
        }

        while (left <= leftLength) {
            tempArray[tempInsertPosition] = src[left];
            tempInsertPosition++;
            left++;
        }

        while (right <= rightLength) {
            tempArray[tempInsertPosition] = src[right];
            right++;
        }

        for (int i = 0; i < tempArray.length ; i++) {
            src[startingPos + i] = tempArray[i];
        }
    }
}
