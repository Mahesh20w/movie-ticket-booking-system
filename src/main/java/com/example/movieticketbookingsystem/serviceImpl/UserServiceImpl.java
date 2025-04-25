package com.example.movieticketbookingsystem.serviceImpl;

import com.example.movieticketbookingsystem.record.UserRegistrationRequestDTO;
import com.example.movieticketbookingsystem.entity.TheatreOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.enums.UserRole;
import com.example.movieticketbookingsystem.record.UserRegistrationResponseDTO;
import com.example.movieticketbookingsystem.repositery.UserDetailsRepositery;
import com.example.movieticketbookingsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDetailsRepositery userdetailsrepositery;


    @Override
    public UserRegistrationResponseDTO register(UserRegistrationRequestDTO userregistrationrequestDTO) {

        if (userdetailsrepositery.existsByEmail(userregistrationrequestDTO.email()))
        {
            throw new RuntimeException("Email already exists!");
        }
        else
        {
            if (userregistrationrequestDTO.userRole() == UserRole.USER)
            {
                User user = new User();

                user.setUsername(userregistrationrequestDTO.username());
                user.setPassword(userregistrationrequestDTO.password());
                user.setEmail(userregistrationrequestDTO.email());
                user.setPhoneNumber(userregistrationrequestDTO.phoneNumber());
                user.setUserRole(userregistrationrequestDTO.userRole());
//                user.setDateOfBirth(userregistrationrequestDTO.dateOfBirth());
//                user.setCreatedAt(userregistrationrequestDTO.getCreatedAt());
//                user.setUpdatedAt(userregistrationrequestDTO.getUpdatedAt());

                userdetailsrepositery.save(user);

                return new UserRegistrationResponseDTO(
                        user.getUserId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getUserRole()
                );

            } else {
                TheatreOwner theaterowner = new TheatreOwner();

                theaterowner.setUsername(userregistrationrequestDTO.username());
                theaterowner.setPassword(userregistrationrequestDTO.password());
                theaterowner.setEmail(userregistrationrequestDTO.email());
                theaterowner.setPhoneNumber(userregistrationrequestDTO.phoneNumber());
                theaterowner.setUserRole(userregistrationrequestDTO.userRole());
//                theaterowner.setDateOfBirth(userregistrationrequestDTO.dateOfBirth());
//                theaterowner.setCreatedAt(userregistrationrequestDTO.getCreatedAt());
//                theaterowner.setUpdatedAt(userregistrationrequestDTO.getUpdatedAt());

                userdetailsrepositery.save(theaterowner);

                return new UserRegistrationResponseDTO(
                        theaterowner.getUserId(),
                        theaterowner.getUsername(),
                        theaterowner.getEmail(),
                        theaterowner.getUserRole()
                );
            }

        }
    }
}