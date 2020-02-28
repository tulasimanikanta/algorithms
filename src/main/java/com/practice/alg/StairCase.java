package com.practice.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StairCase {

    public void findNumberOfWays(int steps, List<Integer> allowedSteps, List<List<Integer>> totalAllowedCombinations) {
        findCombinations(steps, allowedSteps, null, totalAllowedCombinations);
    }

    public void findCombinations(int remainingSteps, List<Integer> allowedSteps, List<Integer> steps, List<List<Integer>> totalAllowedCombinations) {
        if (remainingSteps <= 0) {
            Optional.of(remainingSteps).filter(i -> i ==0).ifPresent(step -> totalAllowedCombinations.add(new ArrayList<>(steps)));
        } else {
            for(Integer step : allowedSteps) {
                Integer climbedSteps = remainingSteps - step;
                List<Integer> tempSteps = Optional.ofNullable(steps).orElse(new ArrayList<>());
                tempSteps.add(step);
                findCombinations(climbedSteps, allowedSteps, tempSteps, totalAllowedCombinations);
                tempSteps.remove(step);
            }
        }
    }
}
