package com.practice.alg;

import java.util.ArrayList;
import java.util.List;

public class CountIdenticalContinuousCharacters {
    public static void main(String[] s) {
        String str= "uuuuxaaaabxuuu";
        char[] strChars = str.toCharArray();
        List<Utils.Key> listChars = new ArrayList<>();
        Utils utils = new Utils();
        for (int charPosition = 0 ; charPosition < strChars.length ;
             charPosition += utils.countSameChars(strChars, listChars, strChars[charPosition], charPosition) ) ;
        listChars.forEach(System.out::println);
    }
}
