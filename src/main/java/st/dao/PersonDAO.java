package st.dao;

import org.springframework.stereotype.Component;
import st.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++peopleCount, "Tom", 23, "gaga@mail.ru"));
        people.add(new Person(++peopleCount, "Bob", 52, "pepega@gmail.com"));
        people.add(new Person(++peopleCount, "Mike", 31, "88005553535@mail.ru"));
        people.add(new Person(++peopleCount, "Katy", 14, "hello@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);

    }
}