package com.example.challenge_dio_api_client_feign.repositories;

import com.example.challenge_dio_api_client_feign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
