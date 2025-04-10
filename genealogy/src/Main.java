import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        PlantUMLRunner.setJarPath("/home/student/Pobrane/plantuml-1.2025.2.jar");
        try {
            List<Person> personList = Person.fromCsv("family.csv");

            Person.toBinaryFile(personList, "family.bin");
            List<Person> family = Person.fromBinaryFile("family.bin");

            System.out.println(family.size());
            for (Person p : family) {
                System.out.println(p);
                System.out.println("Dzieci:");
                for (Person child: p.getChildren()) {
                    System.out.println("\t"+child.getFullName());
                }
            }

            String umlData = Person.umlFromList(
                    family,
                    uml -> uml.replaceFirst("\\{", "#yellow {"),
                    p -> Person.selectDeceased(family).contains(p) || Person.selectOldestAlive(family) == p
                    //Function.identity()
            );
            System.out.println(umlData);
            PlantUMLRunner.generateDiagram(umlData, "/home/student/Pobrane", "diagram.png");

            System.out.println(Person.selectNames(family, "dąb"));
            System.out.println(Person.sortByBirth(family));
            System.out.println(Person.selectDeceased(family));
            System.out.println(Person.selectOldestAlive(family));
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

/*public static void main(String[] args) {
        List<Person> personList = new LinkedList<>();
        personList.add(new Person(
                "Andrzej", "Kowalski",
                LocalDate.of(1980, 1, 1)
        ));
        System.out.println(personList.get(0));
        personList.add(new Person(
                "Bartek", "Kowalski",
                LocalDate.of(2010, 5, 12)
        ));
        personList.add(new Person(
                "Aleksandra", "Kowalska",
                LocalDate.of(2012, 8, 7)
        ));
        personList.add(new Person(
                "Adam", "Kowalski",
                LocalDate.of(2011, 4, 14)
        ));

        System.out.println(personList.get(0).adopt(personList.get(1)));
        System.out.println(personList.get(0).adopt(personList.get(1)));
        System.out.println(personList.get(0).adopt(personList.get(0)));
        System.out.println(personList.get(0).adopt(personList.get(2)));
        personList.get(0).adopt(personList.get(3));

        System.out.println(personList.size());

        for (Person p : personList) {
            System.out.println(p);
        }

        System.out.println();
        System.out.println(personList.get(0).getYoungestChild());
        System.out.println(personList.get(1).getYoungestChild());

        System.out.println();
        System.out.println(personList.get(0).getChildren());

        System.out.println();
        System.out.println("Family");
        Family family = new Family();
        family.add(personList.get(0));
        family.add(personList.get(1), personList.get(2), personList.get(3));
        personList.add(new Person(
                "Bartek", "Kowalski",
                LocalDate.of(2009, 1, 1)
        ));

        System.out.println(family.get("Andrzej Kowalski"));
        System.out.println(family.get("Bartek Kowalski"));
        System.out.println(family.get("Not exist"));
    }*/
