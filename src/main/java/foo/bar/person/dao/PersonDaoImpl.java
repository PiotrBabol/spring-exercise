package foo.bar.person.dao;

import foo.bar.person.bean.Person;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("personDao")
public class PersonDaoImpl implements PersonDao {
    Logger log = Logger.getLogger(PersonDaoImpl.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addPerson(Person person) {
        jdbcTemplate.update("INSERT INTO practicedatabase.person (person_id, first_name, Last_name, age) VALUES (?,?,?,?)", person.getPersonId(), person.getFirstName(), person.getLastName(), person.getAge());
        log.info("Person added");

    }

    @Override
    public void editPerson(Person person, int personId) {
        jdbcTemplate.update("UPDATE practicedatabase.person SET first_name = ? , last_name = ? , age = ? WHERE person_id = ? ", person.getFirstName(), person.getLastName(), person.getAge(), person.getPersonId());
        log.info("Person updated");

    }

    @Override
    public void deletePerson(int personId) {
        jdbcTemplate.update("DELETE FROM practicedatabase.person WHERE person_id=?", personId);
        log.info("Person Deleted");

    }

    @Override
    public Person find(int personId) {
        Person person = jdbcTemplate.queryForObject("SELECT * FROM practicedatabase.person WHERE person_id=?", new Object[]{personId}, new BeanPropertyRowMapper<>(Person.class));
        return person;
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = jdbcTemplate.query("SELECT * FROM practicedatabase.person", new BeanPropertyRowMapper<>(Person.class));
        return people;
    }
}
