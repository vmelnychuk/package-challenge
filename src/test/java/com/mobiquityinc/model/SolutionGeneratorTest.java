package com.mobiquityinc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionGeneratorTest {
    private SolutionGenerator solutionGenerator;

    @Before
    public void setUp() {
        solutionGenerator = new SolutionGenerator();
    }
    @Test
    public void generate() throws Exception {
        int[][] result = solutionGenerator.generate(2);

        int[][] expectedResult = {
            {1, 0}, {0, 1}, {1, 1}
        };
        System.out.println(Arrays.deepToString(result));
        assertArrayEquals(expectedResult, result);
    }

}
