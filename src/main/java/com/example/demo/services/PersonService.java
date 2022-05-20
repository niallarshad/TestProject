package com.example.demo.services;

import com.example.demo.model.Person;

public interface PersonService {

    Person createPerson(Person person);

    Person getPerson();

    Person updatePerson(String id, Person person);

}
