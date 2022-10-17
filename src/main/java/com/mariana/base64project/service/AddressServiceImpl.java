package com.mariana.base64project.service;

import com.google.gson.Gson;
import com.mariana.base64project.DTO.AddressDTO;
import com.mariana.base64project.model.Address;
import com.mariana.base64project.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    @Autowired
    private final AddressRepository addressRepository;

    public AddressDTO addAddress(String base64) {
        log.debug("Encoded String: {}", base64);
        String decodedString = new String(Base64.decodeBase64(base64));
        log.debug("Decoded String: {}",decodedString);
        Gson gson = new Gson();
        Address address = gson.fromJson(decodedString, Address.class);
        log.debug("Object: " + address);

        if(getAddress(address).isEmpty()) {
            addressRepository.save(address);
            return new AddressDTO(address.getId(), address.getStreet(), address.getNumber(), address.getCity(), address.getState(), address.getCountry());
        } else {
            return null;
        }
    }

    public Optional<Address> getAddress(Address address) {
        return addressRepository.findAddress(address.getStreet(),address.getNumber(),address.getCity());
    }
}
