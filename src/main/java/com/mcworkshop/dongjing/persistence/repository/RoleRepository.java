package com.mcworkshop.dongjing.persistence.repository;

import com.mcworkshop.dongjing.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;
import java.util.UUID;

/**
 * Created by markfredchen on 4/10/15.
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Set<Role> findByRoleOIDIn(Set<UUID> roleOIDs);

    Role findOneByRoleOID(UUID roleOID);

    void deleteByRoleOID(UUID roleOID);

    Role findOneByName(String name);
}
