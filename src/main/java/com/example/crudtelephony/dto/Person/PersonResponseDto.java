package com.example.crudtelephony.dto.Person;

import jakarta.persistence.Column;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PersonResponseDto(

        String name,

        int year,

       String phoneNumber,

     String secondPhoneNumber,

     LocalDateTime createdAt
) {
}
