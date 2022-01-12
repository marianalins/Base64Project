package com.mariana.base64project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectBase64Controller {

    @PostMapping("/add")
    public ResponseEntity<?> addObject() {

    }

}
