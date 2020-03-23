package com.practice.alg;

/**
 * Finding all subsets of a given set
 * [a,b,c]
 *  first one loops from 0 to 7 i.e. (000, 001, 010, 011, 100, 101, 110, 111)
 *
 *  second one generates 1(001), 2(010), 4(100)
 * { }
 * { a }
 * { b }
 * { a b }
 * { c }
 * { a c }
 * { b c }
 * { a b c }
 */
public class SubSetsOfArray {
    public static void main(String[] s) {
        char set[] = {'a', 'b', 'c'};
        printSubsets(set);
    }

    static void printSubsets(char[] set) {
        int n = set.length;

        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
