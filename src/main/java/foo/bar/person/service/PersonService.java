package foo.bar.person.service;

import foo.bar.person.bean.Person;

import java.util.List;

public interface PersonService {

    void addPerson(Person person);

    void editPerson(Person person, int personId);

    void deletePerson(int personId);

    Person find(int personId);

    List<Person> findAll();
}
