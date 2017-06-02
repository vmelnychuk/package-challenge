package com.mobiquityinc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class PackageBean {
    public static final String EMPTY_PACKAGE_MARK = "-";
    public static final String INDEX_DELIMITER = ",";
    public static final int MAX_WEIGHT = 100;
    public static final int MIN_WEIGHT = 1;

    private final int limit;
    private List<Thing> things;

    public PackageBean(int limit) {
        this.limit = limit;
        things = new ArrayList<>();
    }

    public int getLimit() {
        return limit;
    }

    public String showContent() {
        if (things.isEmpty()) {
            return EMPTY_PACKAGE_MARK;
        }

        StringJoiner joiner = new StringJoiner(INDEX_DELIMITER);
        for (Thing thing : things) {
            joiner.add(String.valueOf(thing.getIndex()));
        }

        return joiner.toString();
    }
}
