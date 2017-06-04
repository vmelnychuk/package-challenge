package com.mobiquityinc.parser;

import com.mobiquityinc.model.PackageBean;
import com.mobiquityinc.model.Thing;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PackageParserTest {
    private PackageParser packageParser;
    private List<Thing> expectedThings;

    @Before
    public void setUp() {
        packageParser = new PackageParser();
        expectedThings = Arrays.asList(
        new Thing(1, 53.38, 45, "€"),
        new Thing(2, 88.62, 98, "€"),
        new Thing(3, 78.48, 3, "€")
        );
    }

    @Test
    public void parsePackage() throws Exception {
        String packageLine = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3)";
        int expectedWeight = 81;

        PackageBean packageBean = packageParser.parsePackage(packageLine);

        assertEquals(expectedWeight, packageBean.getLimit());
        assertEquals(expectedThings, packageBean.getAllThings());
    }

    @Test
    public void parseThing() throws Exception {
        String thingString = "(1,53.38,€45)";
        Thing expectedThing = new Thing(1, 53.38, 45, "€");

        Thing result = packageParser.parseThing(thingString);

        assertEquals(expectedThing, result);
    }

    @Test
    public void parseThings() throws Exception {
        String thingsString = "(1,53.38,€45) (2,88.62,€98) (3,78.48,€3)";

        List<Thing> result = packageParser.parseThings(thingsString);

        assertThat(result, is(expectedThings));
    }

}
