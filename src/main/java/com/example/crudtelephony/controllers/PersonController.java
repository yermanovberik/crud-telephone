package com.example.crudtelephony.controllers;


import com.example.crudtelephony.dto.Person.PersonResponseDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.crudtelephony.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.crudtelephony.repositories.PersonRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonRepository repository;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PersonResponseDto getById(@PathVariable("id") Long id){
        Person person = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));

        PersonResponseDto responseDto = PersonResponseDto.builder()
                .name(person.getName())
                .year(person.getYear())
                .phoneNumber(person.getPhoneNumber())
                .secondPhoneNumber(person.getSecondPhoneNumber())
                .createdAt(person.getCreatedAt())
                .build();
        return responseDto;
    }

    @GetMapping("/phone/{phoneNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PersonResponseDto getByPhoneNumber(@PathVariable String phoneNumber){
        Person person = repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));

        PersonResponseDto responseDto = PersonResponseDto.builder()
                .name(person.getName())
                .year(person.getYear())
                .phoneNumber(person.getPhoneNumber())
                .secondPhoneNumber(person.getSecondPhoneNumber())
                .createdAt(person.getCreatedAt())
                .build();
        return responseDto;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PersonResponseDto updatedById(@PathVariable Long id){


        return null;
    }





}
