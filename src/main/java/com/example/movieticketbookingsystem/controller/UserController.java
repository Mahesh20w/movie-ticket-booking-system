package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController
{

    private  final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserRegistrationResponseDTO>> register(@Valid @RequestBody UserRegistrationRequestDTO userregistrationrequestDTO){

        UserRegistrationResponseDTO user= userService.register(userregistrationrequestDTO);

        ResponseStructure<UserRegistrationResponseDTO> rs=new ResponseStructure<UserRegistrationResponseDTO>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("registered  successfully");
        rs.setData(user);

        return new ResponseEntity<ResponseStructure<UserRegistrationResponseDTO>>(rs,HttpStatus.CREATED);
    }
}
