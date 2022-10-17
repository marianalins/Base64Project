package com.mariana.base64project.service;

import com.mariana.base64project.DTO.AddressDTO;
import com.mariana.base64project.DTO.PersonDTO;
import com.mariana.base64project.model.Address;
import com.mariana.base64project.model.Person;
import com.mariana.base64project.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AddressServiceImplTest {

    private static final String ADDRESS_BASE64 = "ew0KICAgICJzdHJlZXQiOiAiQXYgQWdhbWVub24gTWFnYWxow6NlcyIsDQogICAgIm51bWJlciI6ICIyMDAwIiwNCiAgICAiY2l0eSI6ICJSZWNpZmUiLA0KICAgICJzdGF0ZSI6ICJQZXJuYW1idWNvIiwNCiAgICAiY291bnRyeSI6ICJCcmF6aWwiDQp9DQo=";
    private static final long ADDRESS_ID = 1;
    private static final String STREET = "Av Agamenon Magalhães";
    private static final String NUMBER = "2000";
    private static final String CITY = "Recife";
    private static final String STATE = "Pernambuco";
    private static final String COUNTRY = "Brazil";


    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void do_not_add_an_address_that_already_exists_in_the_system() {
        when(addressRepository.findAddress(anyString(),anyString(),anyString())).thenReturn(Optional.of(new Address(ADDRESS_ID,STREET,NUMBER,CITY,STATE,COUNTRY)));
        AddressDTO result = addressService.addAddress(ADDRESS_BASE64);

        assertThat(result).isNull();
    }

    @Test
    public void add_new_person_in_the_system() {
        Address address = new Address(ADDRESS_ID,STREET,NUMBER,CITY,STATE,COUNTRY);

        when(addressRepository.findAddress(anyString(),anyString(),anyString())).thenReturn(Optional.empty());
        when(addressRepository.save(address)).thenReturn(address);
        AddressDTO result = addressService.addAddress(ADDRESS_BASE64);

        assertThat(result).isNotNull();
    }


}
