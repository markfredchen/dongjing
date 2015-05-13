package com.mcworkshop.dongjing.service;

import com.mcworkshop.dongjing.domain.Right;
import com.mcworkshop.dongjing.domain.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by markfredchen on 3/26/15.
 */
public interface RoleService {
    UUID createRole(Role role);

    UUID updateRole(Role role);

    Role getRole(UUID roleOID);

    void deleteRole(UUID roleOID);

    List<Role> getAllRoles();

    List<Right> getAllRights();

    Role getRoleByName(String name);
}
