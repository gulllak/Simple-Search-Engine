package search;

import java.util.Set;

public interface SearchMethod {
    Set<Person> findPerson(People people, InvertedIndex invertedIndex);
}
