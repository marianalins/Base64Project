package com.mariana.base64project.controller;

import com.mariana.base64project.model.ObjectBase64;
import com.mariana.base64project.model.Type;
import com.mariana.base64project.service.AddressService;
import com.mariana.base64project.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ObjectBase64")
@Slf4j
public class ObjectBase64Controller {

    @Autowired
    private PersonService personService;
    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<String> addObject(@RequestBody ObjectBase64 objectBase64) {

        log.info("HTTP request");

        if(objectBase64.getType().equalsIgnoreCase(Type.PERSON.toString())) {
            return personService.addPerson(objectBase64.getBase64());
        } else if (objectBase64.getType().equalsIgnoreCase(Type.ADDRESS.toString())) {
            return addressService.addAddress(objectBase64.getBase64());
        }

        return new ResponseEntity<>("NOT PERSON OR ADDRESS", HttpStatus.OK);
    }

}
