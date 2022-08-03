package com.mariana.base64project.service;

import com.mariana.base64project.DTO.PersonDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonService {
    PersonDTO addPerson(String base64);
}
