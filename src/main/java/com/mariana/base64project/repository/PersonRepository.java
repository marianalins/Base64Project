package com.mariana.base64project.repository;

import com.mariana.base64project.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.firstName = ?1 and p.lastName = ?2")
    Optional<Person> findByFullName(String firstName, String lastName);
}
