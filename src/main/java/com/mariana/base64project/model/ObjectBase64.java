package com.mariana.base64project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
public class ObjectBase64 {
    private String id;

    private Enum type;

    private String base64;
}
