import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App1 {

    static class Person {
        enum Position {
            ENGINEER, DIRECTOR, MANAGER;
        }

        private String name;
        private int age;
        private Position position;

        public Person(String name, int age, Position position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob1", 35, Person.Position.MANAGER),
                new Person("Bob2", 44, Person.Position.DIRECTOR),
                new Person("Bob3", 25, Person.Position.ENGINEER),
                new Person("Bob4", 42, Person.Position.ENGINEER),
                new Person("Bob5", 55, Person.Position.MANAGER),
                new Person("Bob6", 19, Person.Position.MANAGER),
                new Person("Bob7", 33, Person.Position.ENGINEER),
                new Person("Bob8", 37, Person.Position.MANAGER)
        ));

        List<Person> engineers = new ArrayList<>();
        for (Person p : persons) {
            if (p.position == Person.Position.ENGINEER) {
                engineers.add(p);
            }
        }

        engineers.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        List<String> engineersNames = new ArrayList<>();
        for (Person p : engineers) {
            engineersNames.add(p.name);
        }

        System.out.println(engineersNames);

        System.out.println(persons.stream()
                .filter(person -> person.position == Person.Position.ENGINEER)
                .sorted((p1, p2) -> p1.age - p2.age)
                .map(p -> p.name)
                .collect(Collectors.toList()));
    }
}
