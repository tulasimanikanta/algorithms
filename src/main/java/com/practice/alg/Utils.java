package com.practice.alg;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Utils {

    public int countSameChars(char[] sourceArray, List<Key> listChars, char character, int startingFrom) {
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
    public static class Key {
        private Integer occurrences;
        private Character character;
    }
}
