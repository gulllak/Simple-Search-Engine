package search;

import java.util.Set;

public class Searching {
    private SearchMethod method;
    public void setMethod(SearchMethod method) {
        this.method = method;
    }
    public void findPerson(People people, InvertedIndex invertedIndex) {
        Set<Person> persons = this.method.findPerson(people, invertedIndex);

        if(persons.size() > 0) {
            System.out.print(persons.size() + " ");
            Menu.foundPerson();
            for(Person person : persons) {
                System.out.println(person.toString().trim());
            }
        } else {
            Menu.notFoundPerson();
        }
    }
}
