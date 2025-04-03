import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p1 = Person.fromCsvLine("Marek Kowalski,15.05.1899,25.06.1957,,");
        System.out.println(p1);

        Person p2 = Person.fromCsvLine("Jan Kowalski,05.03.1992,,,Kacper Kowalski");
        System.out.println(p2);

        List<Person> personList = Person.fromCsv("family.csv");
        System.out.println(personList.size());
        for (Person p: personList) {
            System.out.println(p);
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
