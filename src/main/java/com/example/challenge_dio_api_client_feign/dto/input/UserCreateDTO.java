package com.example.challenge_dio_api_client_feign.dto.input;

import com.example.challenge_dio_api_client_feign.model.Address;
import com.example.challenge_dio_api_client_feign.model.User;

public record UserCreateDTO(
        String name,
        String cpf,
        String cep
) {
    public User convertTo() {
        var address = new Address(this.cep());
        return new User(this.cpf(), this.name(), address);
    }

}
