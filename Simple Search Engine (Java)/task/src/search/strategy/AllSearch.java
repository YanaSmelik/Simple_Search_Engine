package search.strategy;

import java.util.ArrayList;
import java.util.List;

public class AllSearch implements SearchStrategy {

    @Override
    public List<String> search(List<String> inputLines, String queryString) {
        return findQueryStringInLine(inputLines, queryString);
    }

    private List<String> findQueryStringInLine(List<String> inputLines, String queryString) {
        List<String> result = new ArrayList<>();
        String tempLine;

        for (String line : inputLines) {
            tempLine = line.toLowerCase();
            if(tempLine.contains(queryString)) {
                result.add(line);
            }
        }
        return result;
    }
}
