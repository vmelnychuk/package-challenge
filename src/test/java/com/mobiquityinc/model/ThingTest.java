package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

public class ThingTest {
    @Test(expected = APIException.class)
    public void testWrongThing() throws Exception {
        Thing thing = new Thing(1, Thing.MAX_WEIGHT + 10, Thing.MAX_COST + 10, "$");
    }
}
