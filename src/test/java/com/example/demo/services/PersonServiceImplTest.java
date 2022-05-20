package com.example.demo.services;

import com.example.demo.Constants;
import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonServiceImplTest {

    PersonServiceImpl personService = new PersonServiceImpl();

    @Test
    public void createPersonTest() {
        Person person = createPersonForTests("1", "niall", 29);
        assertTrue(person.getId().equalsIgnoreCase("1"));
        assertTrue(person.getName().equalsIgnoreCase("niall"));
        assertEquals(29, person.getAge());
    }

    @Test
    public void getPersonTest() {
        // create person
        createPersonForTests("10", "niallA", 44);
        Person person = personService.getPerson();
        assertTrue(person.getId().equalsIgnoreCase("10"));
        assertTrue(person.getName().equalsIgnoreCase("niallA"));
        assertEquals(44, person.getAge());
    }

    @Test
    public void updatedPersonTest() {
        // create person
        createPersonForTests("11", "niallArshad", 23);
        Person updatedPerson = new Person("11", "Kiba", 24);
        Person person = personService.updatePerson("11", updatedPerson);
        assertTrue(person.getId().equalsIgnoreCase("11"));
        assertTrue(person.getName().equalsIgnoreCase("Kiba"));
        assertEquals(24, person.getAge());
    }



    private Person createPersonForTests(String id, String name, int age) {
        personService.setPath(Constants.testPath);
        return personService.createPerson(new Person(id, name, age));
    }

}