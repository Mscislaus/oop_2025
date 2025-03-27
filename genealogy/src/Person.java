import java.time.LocalDate;

public class Person {
    private final String name, surname;
    private final LocalDate birth;

    public Person(String name, String surname, LocalDate birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
