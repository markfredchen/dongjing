package com.mcworkshop.dongjing.persistence.repository;

import com.mcworkshop.dongjing.domain.Right;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by markfredchen on 4/10/15.
 */
public interface RightRepository extends JpaRepository<Right, Long> {
    Set<Right> findByNameIn(Set<String> names);

    Right findOneByName(String name);
}
