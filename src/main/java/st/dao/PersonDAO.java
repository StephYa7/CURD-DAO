package st.dao;

import org.springframework.stereotype.Component;
import st.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private List<Person> people;
    private static int peopleCount;

    {
        people = new ArrayList<>();

        people.add(new Person(++peopleCount, "John"));
        people.add(new Person(++peopleCount, "Ivan"));
        people.add(new Person(++peopleCount, "Peter"));
        people.add(new Person(++peopleCount, "Bark"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}