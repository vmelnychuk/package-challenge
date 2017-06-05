package com.mobiquityinc.parser;

import com.mobiquityinc.Main;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileParser {
    public static List<String> splitInputFileToLines(String pathToFile) {
        List<String> lines = new ArrayList<>();
        try {
            Scanner scanner = null;
            scanner = new Scanner(Paths.get(pathToFile)).useDelimiter(System.lineSeparator());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (IOException e) {
            Main.printUsage();
        }
        return lines;
    }
}
