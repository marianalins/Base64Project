package com.mariana.base64project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private Date birthday;
}
