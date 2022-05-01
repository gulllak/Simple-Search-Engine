package search;

import java.util.ArrayList;
import java.util.List;

public class People {
    private static final List<Person> people = new ArrayList<>();
    public People (Person person) {
        people.add(person);
    }
    public List<Person> getPeople() {
        return people;
    }
}
