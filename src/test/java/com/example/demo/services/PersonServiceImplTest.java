package com.example.demo.services;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceImplTest {

    PersonServiceImpl personService = new PersonServiceImpl();

    @Test
    public void createPersonTest() {
        Person person = new Person("niall", 29);

        personService.createPerson(person);
    }
}