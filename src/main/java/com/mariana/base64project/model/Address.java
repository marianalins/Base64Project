package com.mariana.base64project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String street;
    private String number;
    private String city;
    private String state;
    private String country;
}
