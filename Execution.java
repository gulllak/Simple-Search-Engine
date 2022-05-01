package search;

import java.io.*;
import java.util.Scanner;
public class Execution {
    public static void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        People people = null;
        InvertedIndex invertedIndex = null;

        if(args != null && args[0].equals("--data")) {
            try {
                File file = new File(args[1]);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                int count = 0;
                while (line != null) {
                    String[] list = line.split("\\s+");
                    people = (list.length) == 1 ? new People(new Person(list[0])) : list.length == 2 ? new People(new Person(list[0], list[1])) : new People(new Person(list[0], list[1], list[2]));
                    for(String str : list) {
                        invertedIndex = new InvertedIndex(str.toLowerCase(), count);
                    }
                    line = bufferedReader.readLine();
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while(true) {
            Menu.menu();
            switch (scanner.nextInt()) {
                case 1:
                        assert invertedIndex != null;
                        chooseStrategy(people, invertedIndex);
                        break;
                case 2: printAllPeople(people);
                        break;
                case 0: System.exit(0);
                default: Menu.wrongInput();
            }
        }
    }
    public static void chooseStrategy(People people, InvertedIndex invertedIndex) {
        Menu.chooseStrategy();
        Searching searching = null;
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "ALL": searching = new Searching();
                        searching.setMethod(new AllSearchingMethod());
                        searching.findPerson(people, invertedIndex);
                        break;
            case "ANY": searching = new Searching();
                        searching.setMethod(new AnySearchingMethod());
                        searching.findPerson(people, invertedIndex);
                        break;
            case "NONE":searching = new Searching();
                        searching.setMethod(new NoneSearchingMethod());
                        searching.findPerson(people, invertedIndex);
                        break;
            default:
                System.out.println("Incorrect query. Try again.");
        }
    }
    public static void printAllPeople (People people) {
        Menu.listAllPeople();
        if (people != null) {
            for(Person person : people.getPeople()) {
                System.out.println(person.toString().trim());
            }
        }
    }
}
