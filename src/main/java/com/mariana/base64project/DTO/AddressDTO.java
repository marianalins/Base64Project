package com.mariana.base64project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AddressDTO {

    private Long id;

    private String street;

    private String number;

    private String city;

    private String state;

    private String country;
}
