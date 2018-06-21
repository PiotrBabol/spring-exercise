package foo.bar.person.dao;

import foo.bar.person.bean.Person;

import java.util.List;

public interface PersonDao {
    void addPerson(Person person);

    void editPerson(Person person, int personId);

    void deletePerson(int personId);

    Person find(int personId);

    List<Person> findAll();
}
