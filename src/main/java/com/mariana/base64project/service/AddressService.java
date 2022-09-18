package com.mariana.base64project.service;

import com.mariana.base64project.DTO.AddressDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressService {
    AddressDTO addAddress(String base64);
}
