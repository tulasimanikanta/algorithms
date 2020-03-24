package com.practice.alg;

import java.util.Arrays;

public class MultiplicationCombsArray {
    static Integer position ;
    public static void main(String[] args) {
        int[] a = {3,4,1,5,7};
        Arrays.sort(a);
        binarySearchUsingRecursion(a, 99, 0, a.length);
        System.out.println("position using recursion " + position);

        System.out.println("position using iterative " + binarySearchUsingLoop(a, 32));

    }

    public static void binarySearchUsingRecursion(int[] src, int searchItem, int start, int end) {
        if (start < end) {
            int pivot = start + ((end-start) / 2);
            if (src[pivot] == searchItem) {
                position = pivot;
            }
            if (src[pivot] > searchItem) {
                binarySearchUsingRecursion(src, searchItem, start, pivot);
            }
            else {
                binarySearchUsingRecursion(src, searchItem, pivot+1, end);
            }
        }
        
    }

    public static int binarySearchUsingLoop(int[] src, int searchItem) {
        int start = 0;
        int end = src.length;
        int position = 99;
        while(start < end) {
             int pivot = start + ((end-start)/2);
            if(src[pivot] == searchItem) {
                position = pivot;
            }
            if (src[pivot] > searchItem) {
                end = pivot;
            } else {
                start = pivot+1;
            }
        }
        return position;
    }
}
