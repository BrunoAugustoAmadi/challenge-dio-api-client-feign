package com.example.challenge_dio_api_client_feign.controllers.user;

import com.example.challenge_dio_api_client_feign.dto.input.UserCreateDTO;
import com.example.challenge_dio_api_client_feign.dto.input.UserUpdateDTO;
import com.example.challenge_dio_api_client_feign.dto.output.UserIdDTO;
import com.example.challenge_dio_api_client_feign.dto.output.UserInfoDTO;
import com.example.challenge_dio_api_client_feign.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
        // criar os DTO de entrada/saida

    @GetMapping("/{id}")
    ResponseEntity<UserInfoDTO> getUser(@PathVariable("id") String id){
        var userId = UUID.fromString(id);
        var userOutput = UserInfoDTO.from(userService.findUser(userId));
        return ResponseEntity.ok(userOutput);
    }

    @PostMapping
    ResponseEntity<UserIdDTO> createUser(@RequestBody UserCreateDTO userCreate){
        var user = userCreate.convertTo();
        var output = UserIdDTO.from(userService.createUser(user));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(output);
    }

    @GetMapping()
    ResponseEntity<List<UserInfoDTO>> findAllUsers (@RequestParam List<String> ids){
        var usersOutput = UserInfoDTO.from(userService.findAll(ids));
        return ResponseEntity.ok(usersOutput);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateUser(@PathVariable String id, @RequestBody UserUpdateDTO user) {
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id){
        var userId = UUID.fromString(id);
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }



}
