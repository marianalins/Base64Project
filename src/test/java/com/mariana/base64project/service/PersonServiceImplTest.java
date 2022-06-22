package com.mariana.base64project.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

@Slf4j
class PersonServiceImplTest {

    private PersonServiceImpl personServiceImpl;

    @Test
    public ResponseEntity<String> addPerson() {
        String base64 = "ew0KICAgICJmaXJzdE5hbWUiOiAiUGF1bG8gUm9iZXJ0byIsDQogICAgImxhc3ROYW1lIjogIkFsbWVpZGEgRmlsaG8iLA0KICAgICJiaXJ0aGRheSI6ICIwMy8xMi8xOTgxIg0KfQ==";

        return personServiceImpl.addPerson(base64);

    }

}