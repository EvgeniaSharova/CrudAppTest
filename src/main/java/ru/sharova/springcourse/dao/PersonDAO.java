package ru.sharova.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.sharova.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_ID;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_ID, "Tom"));
        people.add(new Person(++PEOPLE_ID, "Jon"));
        people.add(new Person(++PEOPLE_ID, "Lot"));
        people.add(new Person(++PEOPLE_ID, "Com"));
        people.add(new Person(++PEOPLE_ID, "Don"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_ID);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
