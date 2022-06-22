package com.mariana.base64project.service;

import com.google.gson.Gson;
import com.mariana.base64project.model.Address;
import com.mariana.base64project.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressRepository addressRepository;

    public ResponseEntity<String> addAddress(String base64) {
        log.info("Encoded String: {}", base64);
        String decodedString = new String(Base64.decodeBase64(base64));
        log.info("Decoded String: {}",decodedString);
        Gson gson = new Gson();
        Address address = gson.fromJson(decodedString, Address.class);
        log.info("Object: " + address);

        if(!getAddress(address).isPresent()) {
            addressRepository.save(address);
            return new ResponseEntity<>("Address added successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("This address already exist in the system", HttpStatus.CONFLICT);
        }
    }

    public Optional<Address> getAddress(Address address) {
        return addressRepository.findAddress(address.getStreet(),address.getNumber(),address.getCity());
    }
}
