package search.program;

import search.strategy.AllSearch;
import search.strategy.AnySearch;
import search.strategy.NoneSearch;
import search.strategy.SearchStrategy;
import search.utils.InputUtils;
import search.utils.OutputUtils;

import java.util.List;

public class Program {

    public void findWordProgram(String arg) {
        boolean continueProgram = true;
        List<String> inputLines = InputUtils.readDataLines(arg);
        while(continueProgram) {
            OutputUtils.printMenu();
            String menuOption = InputUtils.readInputLine();
            continueProgram = performMenuOption(menuOption, inputLines);
        }
    }

    private boolean performMenuOption(String menuOption, List<String> inputLines) {
        int optionNumber = -1;
        try {
            optionNumber = Integer.parseInt(menuOption);
        } catch (Exception e) {
            System.out.println("Incorrect option! Try again.");
            return true;
        }
        if(optionNumber == 1) {
            performQueryStringSearch(inputLines);
            return true;
        }
        if (optionNumber == 2) {
            OutputUtils.printInputLines(inputLines);
            return true;
        }
        if (optionNumber == 0) {
            System.out.println("Bye!");
            return false;
        }
        System.out.println("Incorrect option! Try again.");
        return true;
    }

    public void performQueryStringSearch(List<String> inputLines) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String command = InputUtils.readInputLine();
        System.out.println("Enter a name or email to search all suitable people.");
        String queryString = InputUtils.readInputLine();
        SearchStrategy searchStrategy = invokeSearchStrategy(command.toUpperCase());
        List<String> results = searchStrategy.search(inputLines, queryString.toLowerCase());
        OutputUtils.outputResults(results);
    }

    private SearchStrategy invokeSearchStrategy(String command) {
        if(command.equals("ALL")) {
            return new AllSearch();
        }
        if (command.equals("ANY")) {
            return new AnySearch();
        }
        return new NoneSearch();
    }
}
