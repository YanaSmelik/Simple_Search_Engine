package search.utils;

import java.util.List;

public class OutputUtils {

    public static void outputResults(List<String> results) {
        if (results.size() != 0) {
            System.out.println(results.size() + " persons found: ");
            printLines(results);
        } else {
            System.out.println("No matching people found.");
        }
    }

    public static void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    public static void printInputLines(List<String> inputLines) {
        printLines(inputLines);
    }

    private static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
