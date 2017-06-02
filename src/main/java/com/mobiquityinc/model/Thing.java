package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;

public class Thing {
    public static final int MAX_COST = 100;
    public static final int MIN_COST = 1;

    public static final double MAX_WEIGHT = 100.0;
    public static final double MIN_WEIGHT = 0.10;

    private final int index;
    private final double weight;
    private final int cost;
    private final String currency;

    public Thing(int index, double weight, int cost, String currency) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
        this.currency = currency;
    }

    public int getIndex() {
        return index;
    }

    public double getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public String getCurrency() {
        return currency;
    }
}
