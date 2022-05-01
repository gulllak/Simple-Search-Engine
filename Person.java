package search;

import java.util.List;

public class Person {
    private final String name;
    private final String surname;
    private final String email;

    public Person (String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Person (String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.email = "";
    }

    public Person (String name) {
        this.name = name;
        this.surname = "";
        this.email = "";
    }

    public List<String> getStringPerson() {
        return email == null && surname == null ? List.of(name) : email == null ? List.of(name, surname) : List.of(name, surname, email);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return email == null && surname == null ? name : email == null ? name + " " + surname :  name + " " + surname + " " + email;
    }
}
