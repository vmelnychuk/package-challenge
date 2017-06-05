package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;

import java.util.*;

public class PackageBean {
    public static final String EMPTY_PACKAGE_MARK = "-";
    public static final String INDEX_DELIMITER = ",";
    public static final int MAX_WEIGHT = 100;
    public static final int MIN_WEIGHT = 1;
    public static final int MAX_THING_COUNT = 15;

    private final int limit;
    private List<Thing> packedThings;
    private final List<Thing> allThings;
    private final SolutionGenerator solutionGenerator;
    private SolutionHolder possibleSolution;


    public PackageBean(int limit, List<Thing> allThings) {
        this.limit = limit;
        this.allThings = allThings;
        this.packedThings = new ArrayList<>();
        this.solutionGenerator = new SolutionGenerator();
        validate(this);
    }

    public int getLimit() {
        return limit;
    }

    public List<Thing> getAllThings() {
        return allThings;
    }

    public String showContent() {
        if (packedThings.isEmpty()) {
            return EMPTY_PACKAGE_MARK;
        }

        StringJoiner joiner = new StringJoiner(INDEX_DELIMITER);
        for (Thing thing : packedThings) {
            joiner.add(String.valueOf(thing.getIndex()));
        }

        return joiner.toString();
    }

    public void pack() {
        deleteTooHeavyItems();
        packOtherThings();
    }

    public void packOtherThings() {
        int[][] solutions = solutionGenerator.generate(allThings.size());
        checkSolutions(solutions);

        int[] solution = possibleSolution.getSolution();

        for (int i = 0; i < allThings.size(); i++) {
            if (solution[i] == 1) {
                packedThings.add(allThings.get(i));
            }
        }
    }

    public void deleteTooHeavyItems() {
        for (Iterator<Thing> iterator = allThings.iterator(); iterator.hasNext(); ) {
            Thing thing = iterator.next();
            if (thing.getWeight() > this.getLimit()) {
                iterator.remove();
            }
        }
        this.possibleSolution = new SolutionHolder(0, 0.01, new int [allThings.size()]);
    }

    public void checkSolutions(int[][] solutions) {
        for (int[] solution : solutions) {
            checkSolution(solution);
        }
    }

    public void checkSolution(int[] solution) {
        double totalWeight = 0;
        int totalCost = 0;
        for (int i = 0; i < solution.length; i++) {
            Thing thing = allThings.get(i);
            totalWeight += solution[i] * thing.getWeight();
            totalCost += solution[i] * thing.getCost();
        }
        if (totalWeight <= limit) {
            int currentMaxCost = possibleSolution.getCost();
            double currentMaxWeight = possibleSolution.getWeight();
            if (currentMaxCost <= totalCost) {
                if ((currentMaxCost / currentMaxWeight) <= (totalCost / totalWeight)) {
                    possibleSolution.setCost(totalCost);
                    possibleSolution.setWeight(totalWeight);
                    possibleSolution.setSolution(solution);
                }
            }
        }
    }

    public static void validate(PackageBean packageBean) {
        if (packageBean.getAllThings().size() > MAX_THING_COUNT) {
            throw new APIException(
            String.format("There are too long list of items:[%d]",
            packageBean.getAllThings().size()));
        }

        if (packageBean.getLimit() < MIN_WEIGHT
                || packageBean.getLimit() > MAX_WEIGHT) {
            throw new APIException(
                String.format("The weight of pack:[%d] is incorrect",
                packageBean.getLimit()));
        }
    }
}
