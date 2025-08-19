package com.example.challenge_dio_api_client_feign.services.address;

import com.example.challenge_dio_api_client_feign.client.ViaCep;
import com.example.challenge_dio_api_client_feign.client.dto.AddressClientFeign;
import com.example.challenge_dio_api_client_feign.exceptions.ViaCepException;
import com.example.challenge_dio_api_client_feign.model.Address;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    private final ViaCep viaCep;

    public ViaCepService(ViaCep viaCep) {
        this.viaCep = viaCep;
    }

    public Address findAddress(String cep) {
        try {
            var addressClient = viaCep.searchAddress(cep);
            return convertTo(addressClient);

        } catch (Exception o) {
            throw new ViaCepException("Error to try search cep");
        }
    }

    private Address convertTo(AddressClientFeign addressClientFeign) {
        return new Address(
                addressClientFeign.getCep(),
                addressClientFeign.getLogradouro(),
                addressClientFeign.getComplemento(),
                addressClientFeign.getUnidade(),
                addressClientFeign.getBairro(),
                addressClientFeign.getUf(),
                addressClientFeign.getLocalidade(),
                addressClientFeign.getEstado(),
                addressClientFeign.getRegiao()
        );
    }
}
