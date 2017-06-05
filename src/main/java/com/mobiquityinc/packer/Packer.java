package com.mobiquityinc.packer;

import com.mobiquityinc.model.PackageBean;
import com.mobiquityinc.parser.InputFileParser;
import com.mobiquityinc.parser.PackageParser;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    public static String pack(String path) {
        List<String> packsLines = InputFileParser.splitInputFileToLines(path);

        List<PackageBean> packages = new ArrayList<>();
        PackageParser packageParser = new PackageParser();
        for (String packLine : packsLines) {
            packages.add(packageParser.parsePackage(packLine));
        }

        for (PackageBean packageBean : packages) {
            packageBean.pack();
        }

        StringBuilder result = new StringBuilder();
        for (PackageBean packageBean : packages) {
            result.append(packageBean.showContent());
            result.append("\n");
        }

        return result.toString();
    }
}
