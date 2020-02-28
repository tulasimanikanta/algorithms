package com.practice.alg;

import java.util.stream.IntStream;

public class Permutattions_1 {

    public static void main(String[] s) {
       String charString = "ABCD";
       perms(charString, "");

    }

    public static void perms(String src, String dest) {
        if (src != null) {
           for (int i = 0; i < src.length(); i++) {
               String temp = dest + src.charAt(i);
               perms(removeCharacter(src, i), temp);
           }
        }
        System.out.println("permutation : " + dest);
    }

    public static String removeCharacter(String src, int position) {
        char[] c = src.toCharArray();
        String dest = IntStream.range(0, src.length())
                .filter( i -> i!=position)
                .mapToObj( i-> c[i]).reduce("", (a, b) -> a+b, (s, s2) -> s+s2);
        return dest;
    }
}
