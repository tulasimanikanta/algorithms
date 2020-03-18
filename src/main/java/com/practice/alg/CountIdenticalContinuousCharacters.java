package com.practice.alg;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CountIdenticalContinuousCharacters {
    public static void main(String[] s) {
        String str= "uuuuxaaaabxuuu";
        char[] strChars = str.toCharArray();
        List<Key> listChars = new ArrayList<>();
        for (int charPosition = 0 ; charPosition < strChars.length ;
             charPosition += countSameChars(strChars, listChars, strChars[charPosition], charPosition) ) ;
        listChars.forEach(System.out::println);

    }

    private static int countSameChars(char[] sourceArray, List<Key> listChars, char character, int startingFrom) {
        int count = 0;
        for (int charPosition = startingFrom ; charPosition < sourceArray.length ; charPosition++) {
            if(character==sourceArray[charPosition])
            {
                count ++;
            } else break;
        }
        listChars.add(Key.builder().character(character).occurrences(count).build());
        return count;
    }
    @Getter
    @Setter
    @Builder
    @ToString
    private static class Key {
        private Integer occurrences;
        private Character character;
    }
}
