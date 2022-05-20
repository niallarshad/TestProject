package com.example.demo.services;

import com.example.demo.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.PrintWriter;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    String path = "F:\\ACE\\Desktop\\demo\\Person.json";
    ObjectMapper om = new ObjectMapper();

    public Person createPerson(Person person) {
        String personStr;
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

        return person;
    }
}
