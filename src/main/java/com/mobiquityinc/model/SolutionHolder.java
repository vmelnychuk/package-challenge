package com.mobiquityinc.model;

public class SolutionHolder {
    private int cost;
    private double weight;
    private int[] solution;

    public SolutionHolder(int cost, double weight, int[] solution) {
        this.cost = cost;
        this.weight = weight;
        this.solution = solution;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int[] getSolution() {
        return solution;
    }

    public void setSolution(int[] solution) {
        this.solution = solution;
    }
}
