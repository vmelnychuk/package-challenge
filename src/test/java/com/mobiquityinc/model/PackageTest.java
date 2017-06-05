package com.mobiquityinc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PackageTest {
    private List<Thing> things;

    @Before
    public void setUp() {
        things = Arrays.asList(
        new Thing(1, 53.38, 45, "€"),
        new Thing(2, 88.62, 98, "€"),
        new Thing(3, 78.48, 3, "€")
        );
    }

    @Test
    public void showContentOfEmptyPackage() throws Exception {
        int limit = 10;
        PackageBean pack = new PackageBean(limit, things);

        String result = pack.showContent();

        assertEquals(PackageBean.EMPTY_PACKAGE_MARK, result);
    }

}
