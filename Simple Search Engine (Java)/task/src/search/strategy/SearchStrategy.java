package search.strategy;

import java.util.List;

public interface SearchStrategy {
    List<String> search(List<String> inputLines, String queryString);
}
