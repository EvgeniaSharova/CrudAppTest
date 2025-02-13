package ru.sharova.springcourse.dao;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import ru.sharova.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(1, "Tom"));
        people.add(new Person(2, "Jon"));
        people.add(new Person(3, "Lot"));
        people.add(new Person(4, "Com"));
        people.add(new Person(5, "Don"));
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
}
