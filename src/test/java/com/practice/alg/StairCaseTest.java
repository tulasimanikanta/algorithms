package com.practice.alg;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StairCaseTest {

    StairCase stairCase;

    @BeforeEach
    public void init() {
        stairCase = new StairCase();
    }
    @Test
    public void test1() {
        List<List<Integer>> totalAllowedCombinations = new ArrayList<>();
        stairCase.findNumberOfWays(4, List.of(1,2), totalAllowedCombinations);
        System.out.println(totalAllowedCombinations);
        Assertions.assertEquals(5, totalAllowedCombinations.size());
    }

    @Test
    public void test2() {
        List<List<Integer>> totalAllowedCombinations = new ArrayList<>();
        stairCase.findNumberOfWays(4, List.of(1,3), totalAllowedCombinations);
        System.out.println(totalAllowedCombinations);
        Assertions.assertEquals(3, totalAllowedCombinations.size());
    }
}
