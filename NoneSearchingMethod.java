package search;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class NoneSearchingMethod implements SearchMethod {
    @Override
    public Set<Person> findPerson(People people, InvertedIndex invertedIndex) {
        Menu.inputDataSearch();
        Scanner scanner = new Scanner(System.in);
        List<String> data = List.of(scanner.nextLine().split("\\s"));

        return invertedIndex.getInvertedIndexMap().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(index -> people.getPeople().get(index)))
                .filter(string -> {
                    return data.stream().noneMatch(word -> string.getName().equalsIgnoreCase(word) || string.getSurname().equalsIgnoreCase(word) || string.getEmail().equalsIgnoreCase(word));
                })
                .collect(Collectors.toSet());
    }
}
