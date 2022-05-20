package com.example.demo.webcontroller;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/v1/persons")
    public Person getPerson() {
        return personService.getPerson();
    }

    @PutMapping("/api/v1/persons/{id}")
    public Person updatePerson(@PathVariable(value = "id") String id,
                               @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }
}
