package com.example.crudtelephony.repositories;

import com.example.crudtelephony.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findById(Long id);

    Optional<Person> findByPhoneNumber(String phoneNumber);

}
