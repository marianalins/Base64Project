package com.mariana.base64project.service;

import com.google.gson.Gson;
import com.mariana.base64project.DTO.PersonDTO;
import com.mariana.base64project.model.Person;
import com.mariana.base64project.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;


    public PersonDTO addPerson(String base64) {
        log.debug("Encoded String: {}", base64);
        String decodedString = new String(Base64.decodeBase64(base64));
        log.debug("Decoded String: {}",decodedString);
        Gson gson = new Gson();
        Person person = gson.fromJson(decodedString, Person.class);
        log.debug("Object: " + person);

        if(Optional.ofNullable(getPersonByFullName(person)).isEmpty()) {
            personRepository.save(person);
            return new PersonDTO(person.getId(), person.getFirstName(), person.getLastName(), person.getBirthday());
        } else {
            return null;
        }
    }

    public Optional<Person> getPersonByFullName(Person person) {
        return personRepository.findByFullName(person.getFirstName(),person.getLastName());
    }

}
