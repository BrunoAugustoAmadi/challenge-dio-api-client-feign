package com.example.challenge_dio_api_client_feign.services.user;

import com.example.challenge_dio_api_client_feign.dto.input.UserUpdateDTO;
import com.example.challenge_dio_api_client_feign.exceptions.UserNotFoundException;
import com.example.challenge_dio_api_client_feign.model.Address;
import com.example.challenge_dio_api_client_feign.model.User;
import com.example.challenge_dio_api_client_feign.repositories.UserRepository;
import com.example.challenge_dio_api_client_feign.services.address.ViaCepService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ViaCepService viaCepService;

    public UserServiceImp(UserRepository userRepository,
                          ViaCepService viaCepService) {
        this.userRepository = userRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public User createUser(User user) {
        var address = findAndValidateCep(user.getAddress().getCep());
        user.setAddress(address);

        return userRepository.save(user);
    }

    @Override
    public User findUser(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public List<User> findAll(List<String> usersId) {
        var ids = usersId.stream().map(UUID::fromString).toList();
        return userRepository.findAllById(ids);
    }

    @Override
    public void updateUser(String id, UserUpdateDTO user) {
        var userId = UUID.fromString(id);

        var userFound = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Not Found to update"));

        userFound.setName(user.name());
        userFound.setCpf(user.cpf());

        if (!Objects.isNull(user.cep())) {
            var newAddress = viaCepService.findAddress(user.cep());
            userFound.setAddress(newAddress);
        }

        userRepository.save(userFound);
    }

    @Override
    public void deleteUser(UUID id) {
        var userFound = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User Not Found"));

        userRepository.deleteById(userFound.getId());
    }

    private Address findAndValidateCep(String cep) {
        return viaCepService.findAddress(cep);
    }


}
