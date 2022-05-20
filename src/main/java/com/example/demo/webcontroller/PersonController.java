package com.example.demo.webcontroller;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/api/v1/persons")
    public Person createPerson(@RequestBody Person person) {
        log.info("person {}", person);
        person = personService.createPerson(person);
        return person;
    }
}
