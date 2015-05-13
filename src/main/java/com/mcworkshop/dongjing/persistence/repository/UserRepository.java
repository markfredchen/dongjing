package com.mcworkshop.dongjing.persistence.repository;

import com.mcworkshop.dongjing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by markfredchen on 4/20/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
