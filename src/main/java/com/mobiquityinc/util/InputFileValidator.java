package com.mobiquityinc.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputFileValidator {

    public boolean inputFileIsValid(String[] args) {
        if (args.length != 1) {
            return false;
        }

        Path path = Paths.get(args[0]);
        if (isFileWithPathExists(path)
                && isRegularFile(path)
                && isReadable(path)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFileWithPathExists(Path path) {
        return Files.exists(path);
    }

    public boolean isRegularFile(Path path) {
        return Files.isRegularFile(path);
    }

    public boolean isReadable(Path path) {
        return Files.isReadable(path);
    }

}
