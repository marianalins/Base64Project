package com.mariana.base64project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String birthday;
}
