package com.mobiquityinc.parser;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileParser {
    public static List<String> splitInputFileToLines(String pathToFile) {
        List<String> lines = new ArrayList<>();
        Scanner scanner = null;

        try {
            scanner = new Scanner(Paths.get(pathToFile)).useDelimiter(System.lineSeparator());
        } catch (IOException e) {
            //todo: add log here
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        return lines;
    }
}
