package com.example.challenge_dio_api_client_feign.exceptions;

import feign.FeignException;

public class ViaCepException extends RuntimeException {
    public ViaCepException(String message) {
        super(message);

    }
}
