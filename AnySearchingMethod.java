package search;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AnySearchingMethod implements SearchMethod {
    @Override
    public Set<Person> findPerson(People people, InvertedIndex invertedIndex) {
        Menu.inputDataSearch();
        Scanner scanner = new Scanner(System.in);
        List<String> data = List.of(scanner.nextLine().split("\\s"));

        return invertedIndex.getInvertedIndexMap().entrySet().stream()
                .filter(key -> data.stream().anyMatch(word -> key.getKey().equalsIgnoreCase(word)))
                .flatMap(entry -> entry.getValue().stream().map(index -> people.getPeople().get(index)))
                .collect(Collectors.toSet());
    }
}
