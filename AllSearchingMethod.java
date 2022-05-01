package search;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AllSearchingMethod implements SearchMethod {
    @Override
    public Set<Person> findPerson(People people, InvertedIndex invertedIndex) {
        Menu.inputDataSearch();
        Scanner scanner = new Scanner(System.in);
        List<String> data = List.of(scanner.nextLine().split("\\s"));

        return invertedIndex.getInvertedIndexMap().entrySet().stream()
                .filter(key -> key.getKey().equalsIgnoreCase(data.get(0)))
                .flatMap(entry -> entry.getValue().stream().map(index -> people.getPeople().get(index)))
                .filter(person -> new HashSet<>(person.getStringPerson()).containsAll(data))
                .collect(Collectors.toSet());
    }
}
