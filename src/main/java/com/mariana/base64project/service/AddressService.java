package com.mariana.base64project.service;

import com.mariana.base64project.model.Address;
import com.mariana.base64project.model.ObjectBase64;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressService {
    ResponseEntity<String> addAddress(String base64);
}
