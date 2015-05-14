package com.mcworkshop.dongjing.service;

import com.mcworkshop.dongjing.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by markfredchen on 5/13/15.
 */
public interface UserService {
    UUID createUser(User user);

    UUID updateUser(User user);

    User getUser(UUID userOID);

    void deleteUser(UUID userOID);

    List<User> getAllUsers();

    Optional<User> getUserByUsername(String username);
}
