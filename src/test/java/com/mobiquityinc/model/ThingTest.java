package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThingTest {

    @Test(expected = APIException.class)
    public void tooExpensiveThing() throws Exception {
        int index = 1;
        double weight = 10.24;
        int cost = Thing.MAX_COST + 1;
        String currency = "€";

        Thing thing = new Thing(index, weight, cost, currency);
    }
}
