package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import java.lang.*;

import static org.junit.Assert.*;

public class PackageTest {

    @Test
    public void showContentOfEmptyPackage() throws Exception {
        int weight = 10;
        PackageBean pack = new PackageBean(weight);

        String result = pack.showContent();

        assertEquals(PackageBean.EMPTY_PACKAGE_MARK, result);
    }

    @Test(expected = APIException.class)
    public void tooHeavyPackage() throws Exception {
        int weight = PackageBean.MAX_WEIGHT + 1;

        PackageBean pack = new PackageBean(weight);
    }

}
