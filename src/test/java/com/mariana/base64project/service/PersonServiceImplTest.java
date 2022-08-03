package com.mariana.base64project.service;

import com.mariana.base64project.model.Person;
import com.mariana.base64project.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@Slf4j
class PersonServiceImplTest {

    private static final long PERSON_ID = 1;
    private static final String PERSON_ONE_BASE64 = "ew0KICAgICJmaXJzdE5hbWUiOiAiUGF1bG8gUm9iZXJ0byIsDQogICAgImxhc3ROYW1lIjogIkFsbWVpZGEgRmlsaG8iLA0KICAgICJiaXJ0aGRheSI6ICIwMy8xMi8xOTgxIg0KfQ==";
    private static final String FIRST_NAME = "Paulo Roberto";
    private static final String LAST_NAME = "Almeida Filho";


    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test() {
        Person personOne = new Person(PERSON_ID, FIRST_NAME, LAST_NAME, "03/12/1998");
        when(personRepository.findByFullName(anyString(),anyString())).thenReturn(Optional.of(personOne));
        personService.addPerson(PERSON_ONE_BASE64);
    }
    // resolver problema do personRepositoru estar nulo

    @Test
    public void add_new_person_in_the_system() {
        Person personOne = new Person(PERSON_ID, FIRST_NAME, LAST_NAME, "03/12/1998");

        when(personRepository.findByFullName(FIRST_NAME,LAST_NAME)).thenReturn(Optional.empty());
        when(personRepository.save(personOne)).thenReturn(personOne);

         //ResponseEntity<String> result = personService.addPerson(PERSON_ONE_BASE64);

         //assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
         //assertThat(result.getStatusCodeValue()).isEqualTo();

    }

    @Test
    public void add_person_that_already_exists() {
        Person personOne = new Person(PERSON_ID, FIRST_NAME, LAST_NAME, "03/12/1998");

        when(personRepository.findByFullName(FIRST_NAME,LAST_NAME)).thenReturn(Optional.of(personOne));
        when(personRepository.save(personOne)).thenReturn(personOne);

        //ResponseEntity<String> result = personService.addPerson(PERSON_ONE_BASE64);

        //assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

}