package com.mobiquityinc.parser;

import com.mobiquityinc.model.PackageBean;
import com.mobiquityinc.model.Thing;

import java.util.ArrayList;
import java.util.List;

public class PackageParser {
    public static final String PACKAGE_DELIMITER = " : ";
    public static final String THING_DELIMITER = " ";

    public PackageBean parsePackage(String packageLine) {
        String[] packageParts = packageLine.split(PACKAGE_DELIMITER);
        int limit = Integer.parseInt(packageParts[0]);

        return new PackageBean(limit, parseThings(packageParts[1]));
    }
    public List<Thing> parseThings(String thingsToParse) {
        String[] thingsArray = thingsToParse.split(THING_DELIMITER);
        List<Thing> things = new ArrayList<Thing>();
        for (String thingPart : thingsArray) {
            Thing thing = parseThing(thingPart);
            things.add(thing);
        }
        return things;
    }

    public Thing parseThing(String thingToParse) {
        thingToParse = thingToParse.replaceAll("\\(|\\)", "");
        String[] thingParts = thingToParse.split(",");
        int index = Integer.parseInt(thingParts[0]);
        double weight = Double.parseDouble(thingParts[1]);
        String currency = thingParts[2].substring(0, 1);
        int cost = Integer.parseInt(thingParts[2].substring(1));
        return new Thing(index, weight, cost, currency);
    }
}
