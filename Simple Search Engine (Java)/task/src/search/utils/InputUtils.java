package search.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readInputLine() {
        return scanner.nextLine();
    }

    public static List<String> readDataLines (String arg){
        String input = "";
        try {
            input = new String(Files.readAllBytes(Paths.get(arg)));
        } catch (IOException ignored) {}
        return Arrays.asList(input.split("\n"));


    }

}
