package com.mobiquityinc;

import com.mobiquityinc.packer.Packer;
import com.mobiquityinc.util.InputFileValidator;

public class Main {
    public static void main(String[] args) {
        InputFileValidator inputFileValidator = new InputFileValidator();

        // for IDEA run
        args = new String[] {"/tmp/input-example.txt"};

        if (!inputFileValidator.inputFileIsValid(args)) {
            printUsage();
        }

        System.out.println(Packer.pack(args[0]));
    }

    public static void printUsage() {
        System.err.println("Please provide input file ");
        System.exit(1);
    }
}
