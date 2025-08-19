package com.example.challenge_dio_api_client_feign.services.user;

import com.example.challenge_dio_api_client_feign.dto.input.UserUpdateDTO;
import com.example.challenge_dio_api_client_feign.model.User;

import java.util.List;
import java.util.UUID;


public interface UserService {

    User createUser(User user);

    User findUser(UUID id);

    List<User> findAll(List<String> usersId);

    void updateUser(String id, UserUpdateDTO user);

    void deleteUser(UUID id);

}
