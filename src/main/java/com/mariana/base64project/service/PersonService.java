package com.mariana.base64project.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonService {
    ResponseEntity<String> addPerson(String base64);
}
