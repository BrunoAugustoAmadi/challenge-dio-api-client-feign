package com.example.challenge_dio_api_client_feign.client;


import com.example.challenge_dio_api_client_feign.client.dto.AddressClientFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCep {

    @GetMapping("/{cep}/json")
    AddressClientFeign searchAddress (@PathVariable("cep") String cep);
}
