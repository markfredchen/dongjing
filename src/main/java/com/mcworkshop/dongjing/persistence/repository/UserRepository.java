package com.mcworkshop.dongjing.persistence.repository;

import com.mcworkshop.dongjing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by markfredchen on 4/20/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);

    User findOneByUserOID(UUID userOID);

    Long deleteByUserOID(UUID userOID);
}
