package com.practice.alg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Given a positive integer n and 3 operations on n:
 *
 * n - 1
 * n / 2 (if n is even)
 * n / 3 (if n % 3 == 0)
 * Find the minimum number of above operations to reduce n to 1.
 */
public class MinimumOperations {
    static Function<Integer, Integer> func1 = sub -> sub - 1;
    static Function<Integer, Integer> func2 = div -> div / 2;
    static Function<Integer, Integer> func3 = div -> div / 3;
    static List<Integer> integers = new ArrayList<>();
    public static void main(String[] s) {
        List<Function<Integer, Integer>> functions = List.of(func1, func2, func3);
        callRecursively(8, 0, functions);
        System.out.println(integers.stream().min(Comparator.comparingInt(t -> t)).get());
    }
    public static void callRecursively(int n, int appliedTimes, List<Function<Integer, Integer>> functions) {
        if (n == 1 ) integers.add(appliedTimes);
        if (n > 1) {

           for (Function<Integer, Integer> function : functions) {

                int appliedValue = function.apply(n);
                callRecursively(appliedValue, appliedTimes + 1, functions);
           }
        }
    }
}
