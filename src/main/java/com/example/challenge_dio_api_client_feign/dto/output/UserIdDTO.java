package com.example.challenge_dio_api_client_feign.dto.output;

import com.example.challenge_dio_api_client_feign.model.User;

public record UserIdDTO(String id) {

    public static UserIdDTO from (User user){
        return new UserIdDTO(user.getId().toString());
    }
}
