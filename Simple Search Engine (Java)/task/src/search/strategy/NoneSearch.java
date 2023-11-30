package search.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoneSearch implements SearchStrategy{

    @Override
    public List<String> search(List<String> inputLines, String queryString) {
        return findLinesWithoutQueryString(inputLines, queryString);
    }

    private List<String> findLinesWithoutQueryString(List<String> inputLines, String queryString) {
        List<String> result = new ArrayList<>();
        List<String> queryTokens = List.of(queryString.split(" "));
        List<String> lineTokens;
        String tempLine;

        for (String line : inputLines) {
            tempLine = line.toLowerCase();
            lineTokens = List.of(tempLine.split(" "));
            if(Collections.disjoint(lineTokens, queryTokens)) {
                result.add(line);
            }
        }
        return result;
    }
}
