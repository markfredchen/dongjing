package com.mcworkshop.dongjing.web.api.resource.asm;

import com.mcworkshop.dongjing.domain.Right;
import com.mcworkshop.dongjing.domain.Role;
import com.mcworkshop.dongjing.web.api.resource.RoleResource;

import java.util.stream.Collectors;

/**
 * Created by markfredchen on 4/10/15.
 */
public class RoleResourceAsm implements ResourceAssembler<RoleResource, Role> {
    @Override
    public RoleResource toResource(Role role) {
        RoleResource roleResource = new RoleResource();
        roleResource.setRoleOID(role.getRoleOID().toString());
        roleResource.setName(role.getName());
        if (role.getRights().size() > 0) {
            roleResource.setRights(role.getRights().stream().map(Right::getName).collect(Collectors.toSet()));
        }
        return roleResource;
    }
}
