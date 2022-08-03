package com.mariana.base64project.controller;

import com.mariana.base64project.DTO.PersonDTO;
import com.mariana.base64project.model.ObjectBase64;
import com.mariana.base64project.model.Type;
import com.mariana.base64project.service.AddressService;
import com.mariana.base64project.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ObjectBase64")
@Slf4j
@RequiredArgsConstructor
public class ObjectBase64Controller {

    private PersonService personService;

    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<String> addObject(@RequestBody ObjectBase64 objectBase64) {
        PersonDTO person;
        log.info("HTTP request");

        if(objectBase64.getType().equalsIgnoreCase(Type.PERSON.toString())) {
            person = personService.addPerson(objectBase64.getBase64());

            if (person != null)  {
                new ResponseEntity<>(person.getFirstName() + " " + person.getLastName() + " added successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Person already exists in the system.", HttpStatus.CONFLICT);
            }

        } else if (objectBase64.getType().equalsIgnoreCase(Type.ADDRESS.toString())) {
            return addressService.addAddress(objectBase64.getBase64());
        }

        return new ResponseEntity<>("NOT PERSON OR ADDRESS", HttpStatus.OK);
    }

}
