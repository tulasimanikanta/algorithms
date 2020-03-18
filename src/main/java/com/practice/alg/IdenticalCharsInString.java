package com.practice.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

/**
 * Write a function solution that, given a string S of N lowercase English letters,
 * returns a string with no instances of three identical consecutive letters,
 * obtained from S by deleting the minimum possible number of letters.
 * Examples:
 * Given S = “eedaaad” , the function should return “eedaad” .
 *      One occurrence of letter a is deleted.
 * Given S = “xxxtxxx” , the function should return “xxtxx” .
 *      Note that letter x can occur more than three times in the returned string, if the occurrences are not consecutive.
 * Given S = “uuuuxaaaaxuuu” , the function should return “uuxaaxuu”.
 */
public class IdenticalCharsInString {
    public static void main(String[] s) {
        String str= "uuuuxaaaaxuuu";
        char[] strChars = str.toCharArray();
        List<Character> listChars = new ArrayList<>();
        for (int charPosition = 0 ; charPosition < strChars.length ; charPosition++) {
            if (!allCharsSameInSequence(strChars, charPosition, 2)) {
                listChars.add(strChars[charPosition]);
            }
        }
        String modifiedString  = listChars.stream().collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
        System.out.println(modifiedString);
    }
    public static boolean allCharsSameInSequence(char[] array, int starting, int length) {
        if(array.length > starting + length) {
            return array[starting] == array[starting+1] && array[starting+1] == array[starting+2];
        }
        return false;
    }
}
