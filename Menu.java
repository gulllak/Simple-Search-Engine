package search;

public class Menu {

    public static void inputDataSearch() {
        System.out.println("\nEnter a name or email to search all suitable people.");
    }
    public static void chooseStrategy() {
        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
    }

    public static void foundPerson() {
        System.out.println("persons found:");
    }

    public static void notFoundPerson() {
        System.out.println("\nNo matching people found.");
    }

    public static void menu() {
        System.out.println("\n" +
                "=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");
    }
    public static void wrongInput() {
        System.out.println("Incorrect option! Try again.");
    }

    public static void listAllPeople() {
        System.out.println("\n=== List of people ===");
    }
}
