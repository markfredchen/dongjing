package com.mcworkshop.dongjing.web.api.resource.asm;

import com.mcworkshop.dongjing.domain.User;
import com.mcworkshop.dongjing.web.api.resource.UserResource;

import java.util.stream.Collectors;

/**
 * Created by markfredchen on 5/13/15.
 */
public class UserResourceAsm implements ResourceAssembler<UserResource, User> {
    @Override
    public UserResource toResource(User user) {
        UserResource userResource = new UserResource();
        userResource.setUserOID(user.getUserOID().toString());
        userResource.setUsername(user.getUsername());
        userResource.setPassword(user.getPassword());
        userResource.setEmail(user.getEmail());
        userResource.setFirstName(user.getFirstName());
        userResource.setLastName(user.getLastName());
        userResource.setCellPhone(user.getCellPhone());
        userResource.setPhone(user.getPhone());
        userResource.setTitle(user.getTitle());
        userResource.setDepartment(user.getDepartment());
        userResource.setRoleOIDs(user.getRoles().stream().map(role -> role.getRoleOID().toString()).collect(Collectors.toSet()));
        return userResource;
    }
}
