package com.practice.alg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Combinations {
    public static Integer number = 0;
    public static Set<List<Integer>> listSet = new HashSet<>();

    public static void main(String[] s) {
        int[] arrayOfInts = IntStream.rangeClosed(1,5).toArray();
        int[] tempArray = new int[arrayOfInts.length];
        combinations(arrayOfInts, tempArray, 0, arrayOfInts.length, new Combinations());
        System.out.println(listSet);
    }

    public static void combinations(int[] srcArray, int[] tempArray, int k, int n, Combinations numberOfCombs) {

        if (k == n) {
            print(tempArray);
            Combinations.number++;
            List<Integer> list = Arrays.stream(tempArray).boxed().collect(Collectors.toList());
            listSet.add(list);
            return;
        }
        tempArray[k] = 0;
        combinations(srcArray, tempArray, k+1, n, numberOfCombs);
        tempArray[k] = srcArray[k];
        combinations(srcArray, tempArray, k+1, n, numberOfCombs);

    }
    private static void print(int[] array) {
        System.out.println("start set");
        Arrays.stream(array).filter(element -> element != 0).forEach(System.out::print);
        System.out.println("completed");
    }
}
