package search;

import java.util.*;

public class InvertedIndex {
    private static final Map<String, List<Integer>> invertedIndexMap = new HashMap<>();
    public InvertedIndex(String word, Integer index) {
        if(invertedIndexMap.containsKey(word)) {
            List<Integer> list = invertedIndexMap.get(word);
            list.add(index);
            invertedIndexMap.put(word, list);
        } else {
            invertedIndexMap.put(word, new ArrayList<>());
            invertedIndexMap.get(word).add(index);
        }
    }
    public Map<String, List<Integer>> getInvertedIndexMap() {
        return invertedIndexMap;
    }
}
