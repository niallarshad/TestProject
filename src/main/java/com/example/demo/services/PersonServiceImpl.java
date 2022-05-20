package com.example.demo.services;

import com.example.demo.Constants;
import com.example.demo.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.util.Random;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    String path = Constants.livePath;
    ObjectMapper om = new ObjectMapper();

    @Override
    public Person createPerson(Person person) {
        String personStr;
        try {
            personStr = om.writeValueAsString(person);
            log.info(personStr);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if (person.getId().isEmpty()) {
            Random rn = new Random();
            person.setId(Integer.toString(rn.nextInt(100) + 1));
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(personStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person getPerson() {
        Person person;
        try {
            person = om.readValue(new File(path), Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    @Override
    public Person updatePerson(String id, Person person) {
        Person oldPerson;
        // Fetch person from database
        try {
            oldPerson = om.readValue(new File(path), Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String personStr;

        // if person id is the same as id of person fetched from database then update the person
        if(oldPerson.getId().equalsIgnoreCase(id)) {
            person.setId(id);
            try {
                personStr = om.writeValueAsString(person);
                log.info(personStr);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
                out.write(personStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Person not found"
            );
        }
        return person;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
