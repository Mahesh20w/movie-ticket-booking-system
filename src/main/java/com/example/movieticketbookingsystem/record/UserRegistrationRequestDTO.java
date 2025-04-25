package com.example.movieticketbookingsystem.record;

import com.example.movieticketbookingsystem.enums.UserRole;

public record UserRegistrationRequestDTO(
        String username,
        String email,
        String password,
        String phoneNumber,
        UserRole userRole
        ) {
}
