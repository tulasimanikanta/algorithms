package com.practice.alg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DecodeString {
    public static Map<Integer, Character> integerStringMap = new HashMap<>();
    public static final Integer INITIAL_KEY = 1;
    public static Integer MAX_VALUES ;
    public static Set<List<Character>> listSet = new HashSet<>();

   static  {
        integerStringMap.put(1, 'A');
        integerStringMap.put(2, 'B');
       integerStringMap.put(3, 'C');
       integerStringMap.put(4, 'D');
       integerStringMap.put(5, 'E');
       integerStringMap.put(6, 'F');
       integerStringMap.put(7, 'G');
       integerStringMap.put(8, 'H');
       integerStringMap.put(9, 'I');
       integerStringMap.put(10, 'J');
       integerStringMap.put(11, 'K');
       integerStringMap.put(12, 'L');
       integerStringMap.put(13, 'M');
       integerStringMap.put(14, 'N');
       integerStringMap.put(15, 'O');
       integerStringMap.put(16, 'P');
       integerStringMap.put(17, 'Q');
       integerStringMap.put(18, 'R');
       integerStringMap.put(19, 'S');
       integerStringMap.put(20, 'T');
       integerStringMap.put(21, 'U');
       integerStringMap.put(22, 'V');
       integerStringMap.put(23, 'W');
       integerStringMap.put(24, 'X');
       integerStringMap.put(25, 'Y');
       integerStringMap.put(26, 'Z');
       MAX_VALUES = integerStringMap.size();
    }
    public static void main(String[] a) {

        String input = "12865";
        List<Integer> integerList = input.chars().filter(Character::isDigit)
                .map(Character::getNumericValue).boxed().collect(Collectors.toList());
       /* Integer numberOfWays = 0;

            for (int i =0 ; i < integerList.size(); i++) {
                Character character = integerStringMap.get(integerList.get(i));
                if (character == null) {
                    numberOfWays = 0;
                    break;
                } else {
                   numberOfWays = 1;
                }
                if (i+1 < integerList.size()) {
                    Character temp = integerStringMap.get(Integer.decode(integerList.get(i).toString() + integerList.get(i+1).toString()));
                    if (temp != null) {
                        numberOfWays = 2; break;
                    }
                }
            }
        System.out.println(numberOfWays);
       // System.out.println(integerList);*/

        System.out.println(fillWaysToList(integerList, 0));

    }

    public static int fillWaysToList(List<Integer> source, int position) {
       if (position >= source.size()) { return 1;}
       if (integerStringMap.get(source.get(position)) == null) {
           return 0;
       }
        int result = fillWaysToList(source, position+1);
       if (position+1 < source.size()) {
           Character temp = integerStringMap.get(Integer.decode(source.get(position).toString() + source.get(position + 1).toString()));
           if (temp != null) {
               result += fillWaysToList(source, position + 2);
           }
       }
        return result;
    }
}
