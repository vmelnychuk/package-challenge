package com.mobiquityinc.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PackageTest {

    @Test
    public void showContentOfEmptyPackage() throws Exception {
        int limit = 10;
        PackageBean pack = new PackageBean(limit, null);

        String result = pack.showContent();

        assertEquals(PackageBean.EMPTY_PACKAGE_MARK, result);
    }

}
