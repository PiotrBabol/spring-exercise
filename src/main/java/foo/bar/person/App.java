package foo.bar.person;

import foo.bar.person.bean.Person;
import foo.bar.person.configuration.ApplicationConfig;
import foo.bar.person.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PersonService personService = (PersonService) context.getBean("personService");

        Person first = new Person(1, "First", "Person", 20);
        Person second = new Person(2, "Second", "Person", 25);
        Person third = new Person(3, "Third", "Person", 30);

        //adding
        personService.addPerson(first);
        personService.addPerson(second);
        personService.addPerson(third);

        //deleting
        int deleteThirdId = 3;
        personService.deletePerson(deleteThirdId);

        //updating
        first.setAge(30);
        int updateFirstId = 1;
        personService.editPerson(first, updateFirstId);

        //find
        System.out.println("Person id 1");
        Person person = personService.find(1);
        System.out.println(person);


    }
}
