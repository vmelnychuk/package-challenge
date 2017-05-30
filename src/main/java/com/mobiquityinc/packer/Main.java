package com.mobiquityinc.packer;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            printUsage();
        }

        String path = args[0];
        System.out.println("path is " + path);
    }

    public static void printUsage() {
        System.err.println("Please provide input file ");
        System.exit(1);
    }
}
