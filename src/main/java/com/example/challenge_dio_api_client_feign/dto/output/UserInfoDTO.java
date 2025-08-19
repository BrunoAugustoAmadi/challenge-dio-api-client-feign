package com.example.challenge_dio_api_client_feign.dto.output;

import com.example.challenge_dio_api_client_feign.model.User;

import java.util.List;

public record UserInfoDTO(
        String id,
        String name,
        String cpf,
        UserInfoAddressDTO address

) {

    public record UserInfoAddressDTO(
            String cep,
            String logradouro,
            String complemento,
            String unidade,
            String bairro,
            String localidade,
            String uf,
            String estado,
            String regiao
    ) {

    }

    public static UserInfoDTO from(User user) {
        var address = new UserInfoAddressDTO(
                user.getAddress().getCep(),
                user.getAddress().getLogradouro(),
                user.getAddress().getComplemento(),
                user.getAddress().getUnidade(),
                user.getAddress().getBairro(),
                user.getAddress().getLocalidade(),
                user.getAddress().getUf(),
                user.getAddress().getEstado(),
                user.getAddress().getRegiao()
        );

        return new UserInfoDTO(
                user.getId().toString(),
                user.getName(),
                user.getCpf(),
                address
        );
    }

    public static List<UserInfoDTO> from(List<User> users) {
        return users.stream().map(user -> {
            var address = new UserInfoAddressDTO(
                    user.getAddress().getCep(),
                    user.getAddress().getLogradouro(),
                    user.getAddress().getComplemento(),
                    user.getAddress().getUnidade(),
                    user.getAddress().getBairro(),
                    user.getAddress().getLocalidade(),
                    user.getAddress().getUf(),
                    user.getAddress().getEstado(),
                    user.getAddress().getRegiao()
            );
            return new UserInfoDTO(
                    user.getId().toString(),
                    user.getName(),
                    user.getCpf(),
                    address
            );

        }).toList();

    }
}
