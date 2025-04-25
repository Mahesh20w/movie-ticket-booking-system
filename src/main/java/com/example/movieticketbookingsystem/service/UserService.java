package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;
import jakarta.validation.Valid;

public interface UserService {
    UserRegistrationResponseDTO register(@Valid UserRegistrationRequestDTO userregistrationrequestDTO);
}

