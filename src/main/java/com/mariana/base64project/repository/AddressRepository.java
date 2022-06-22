package com.mariana.base64project.repository;

import com.mariana.base64project.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("select a from Address a where a.street = ?1 and a.number = ?2 and a.city = ?3")
    Optional<Address> findAddress(String street, String number, String city);
}
