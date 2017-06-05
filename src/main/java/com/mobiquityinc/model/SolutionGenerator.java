package com.mobiquityinc.model;

import java.util.Arrays;

public class SolutionGenerator {

    public int[][] generate(int len) {
        int rows = (int) Math.pow(2, len);
        int[][] solutions = new int[rows][len];

        for (int i = 0; i < solutions.length; i++) {
            for (int j = 0; j < solutions[i].length; j++) {
                int val = solutions.length * j + i;
                int ret = (1 & (val >>> j));
                solutions[i][j] = ret != 0 ? 1 : 0;
            }
        }

        return Arrays.copyOfRange(solutions, 1, solutions.length);
    }
}
