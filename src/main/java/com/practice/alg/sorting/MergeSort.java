package com.practice.alg.sorting;

import java.util.Arrays;

public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int l, int m, int r)
    {
        // Find sizes of two sub arrays to be merged
        int leftArrayLength = m - l + 1;
        int rightArrayLength = r - m;

        /* Create temp arrays */
        int[] left = new int [leftArrayLength];
        int[] right = new int [rightArrayLength];

        /*Copy original left array to temp left array*/
        for (int i=0; i<leftArrayLength; ++i)
            left[i] = arr[l + i];

        /*Copy original left array to temp left array*/
        for (int j=0; j<rightArrayLength; ++j)
            right[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < leftArrayLength && j < rightArrayLength)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of left[] if any */
        while (i < leftArrayLength)
        {
            arr[k] = left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of right[] if any */
        while (j < rightArrayLength)
        {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    void sort(int[] arr, int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        Arrays.stream(arr).forEach(System.out::print);

        MergeSort sorter = new MergeSort();
        sorter.sort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
