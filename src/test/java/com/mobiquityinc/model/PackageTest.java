package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import java.lang.*;

import static org.junit.Assert.*;

public class PackageTest {

    @Test
    public void showContentOfEmptyPackage() throws Exception {
        int limit = 10;
        PackageBean pack = new PackageBean(limit, null);

        String result = pack.showContent();

        assertEquals(PackageBean.EMPTY_PACKAGE_MARK, result);
    }

    @Test(expected = APIException.class)
    public void tooHeavyPackage() throws Exception {
        int limit = PackageBean.MAX_WEIGHT + 1;

        PackageBean pack = new PackageBean(limit, null);
    }

}
