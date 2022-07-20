package com.mariana.base64project.service;

import com.google.gson.Gson;
import com.mariana.base64project.model.Person;
import com.mariana.base64project.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Slf4j
@Component
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;


    public ResponseEntity<String> addPerson(String base64) {
        log.info("Encoded String: {}", base64);
        String decodedString = new String(Base64.decodeBase64(base64));
        log.info("Decoded String: {}",decodedString);
        Gson gson = new Gson();
        Person person = gson.fromJson(decodedString, Person.class);
        log.info("Object: " + person);

        if(Optional.ofNullable(getPersonByFullName(person)).isEmpty()) {
            personRepository.save(person);
            return new ResponseEntity<>("Person added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(person.getFirstName() +" " + person.getLastName() +" already exist in the system", HttpStatus.CONFLICT);
        }

    }

    public Optional<Person> getPersonByFullName(Person person) {
        return personRepository.findByFullName(person.getFirstName(),person.getLastName());
    }

}
