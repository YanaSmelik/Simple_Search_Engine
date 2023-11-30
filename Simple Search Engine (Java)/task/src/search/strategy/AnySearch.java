package search.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnySearch implements SearchStrategy {

    @Override
    public List<String> search(List<String> inputLines, String queryString) {
        return findQueryStringInLine(inputLines, queryString);
    }

    private List<String> findQueryStringInLine(List<String> inputLines, String queryString) {
        List<String> result = new ArrayList<>();
        Map<String, List<Integer>> invertedIndex = createInvertedIndexMap(inputLines);
        List<String> queryTokens = List.of(queryString.split(" "));

        for (String token : queryTokens) {
            List<Integer> resultLines = invertedIndex.get(token);
            if (resultLines != null) {
                for (Integer resultLine : resultLines) {
                    result.add(inputLines.get(resultLine));
                }
            }
        }


        return result;
    }

    private Map<String, List<Integer>> createInvertedIndexMap(List<String> inputLines) {
        Map<String, List<Integer>> invertedIndex = new HashMap<>();
        int index = 0;
        for (String line : inputLines) {
            List<String> words = List.of(line.split(" "));
            for (String word : words) {
                word = word.toLowerCase();
                if (invertedIndex.containsKey(word)) {
                    invertedIndex.get(word).add(index);
                } else {
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(index);
                    invertedIndex.put(word, indexes);
                }
            }
            index++;
        }
        return invertedIndex;
    }
}
