package com.mariana.base64project.service;

import com.mariana.base64project.DTO.PersonDTO;
import com.mariana.base64project.model.Person;
import com.mariana.base64project.repository.PersonRepository;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

class PersonServiceImplTest {

    private static final long PERSON_ID = 1;
    private static final String PERSON_ONE_BASE64 = "ew0KICAgICJmaXJzdE5hbWUiOiAiUGF1bG8gUm9iZXJ0byIsDQogICAgImxhc3ROYW1lIjogIkFsbWVpZGEgRmlsaG8iLA0KICAgICJiaXJ0aGRheSI6ICIwMy8xMi8xOTgxIg0KfQ==";
    private static final String FIRST_NAME = "Paulo Roberto";
    private static final String LAST_NAME = "Almeida Filho";
    private static final String BIRTHDAY = "03/12/1981";

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void do_not_add_a_person_that_already_exists_in_the_system() {
        when(personRepository.findByFullName(anyString(),anyString())).thenReturn(Optional.of(new Person(PERSON_ID, FIRST_NAME, LAST_NAME, BIRTHDAY)));
        PersonDTO result = personService.addPerson(PERSON_ONE_BASE64);

        assertThat(result).isNull();
    }

    @Test
    public void add_new_person_in_the_system() {
        Person personOne = new Person(PERSON_ID, FIRST_NAME, LAST_NAME, BIRTHDAY);

        when(personRepository.findByFullName(anyString(),anyString())).thenReturn(Optional.empty());
        when(personRepository.save(personOne)).thenReturn(personOne);
        PersonDTO result = personService.addPerson(PERSON_ONE_BASE64);

        assertThat(result).isNotNull();
    }
}