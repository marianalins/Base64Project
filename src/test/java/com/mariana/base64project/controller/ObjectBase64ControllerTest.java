package com.mariana.base64project.controller;

import com.mariana.base64project.model.ObjectBase64;
import com.mariana.base64project.model.Type;
import com.mariana.base64project.service.AddressService;
import com.mariana.base64project.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ObjectBase64ControllerTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private AddressService addressService;

    @Test
    public ResponseEntity<String> addObject(ObjectBase64 objectBase64) {
        log.info("HTTP request");
        if(objectBase64.getType().equalsIgnoreCase(Type.PERSON.toString())) {
            personService.addPerson(objectBase64.getBase64());
            return new ResponseEntity<>("Person added successfully!", HttpStatus.OK);
        } else if (objectBase64.getType().equalsIgnoreCase(Type.ADDRESS.toString())) {
            addressService.addAddress(objectBase64.getBase64());
            return new ResponseEntity<>("Address added successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("NOT PERSON OR ADDRESS", HttpStatus.OK);
    }
}