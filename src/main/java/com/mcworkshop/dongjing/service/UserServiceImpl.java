package com.mcworkshop.dongjing.service;

import com.mcworkshop.dongjing.domain.Role;
import com.mcworkshop.dongjing.domain.User;
import com.mcworkshop.dongjing.persistence.repository.RoleRepository;
import com.mcworkshop.dongjing.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by markfredchen on 5/13/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public UUID createUser(User user) {
        user.setUserOID(UUID.randomUUID());
        Set<Role> roles = roleRepository.findByRoleOIDIn(user.getRoles().stream().map(role -> role.getRoleOID()).collect(Collectors.toSet()));
        user.setRoles(roles);
        userRepository.save(user);
        return user.getUserOID();
    }

    @Override
    public UUID updateUser(User user) {
        User persisted = userRepository.findOneByUserOID(user.getUserOID());
        persisted.setEmail(user.getEmail());
        persisted.setFirstName(user.getFirstName());
        persisted.setLastName(user.getLastName());
        persisted.setCellPhone(user.getCellPhone());
        persisted.setPhone(user.getPhone());
        persisted.setTitle(user.getTitle());
        persisted.setDepartment(user.getDepartment());
        userRepository.save(persisted);
        return user.getUserOID();
    }

    @Override
    public User getUser(UUID userOID) {
        return userRepository.findOneByUserOID(userOID);
    }

    @Override
    public void deleteUser(UUID userOID) {
        userRepository.deleteByUserOID(userOID);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }
}
