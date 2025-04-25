package com.example.movieticketbookingsystem.repositery;

import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepositery extends JpaRepository<UserDetails,String>
{
    boolean existsByEmail(String email);
}
