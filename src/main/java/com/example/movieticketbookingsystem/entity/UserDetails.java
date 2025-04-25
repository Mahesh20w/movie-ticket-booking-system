package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails
{
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private  String userId;
   private  String username;
   private String email;
   private  String password;
   private  String phoneNumber;

   @Enumerated(EnumType.STRING)
   private UserRole userRole;
   private LocalDate dateOfBirth;
   private  Long   createdAt;
   private  Long updateAt;
}
