package com.mcworkshop.dongjing.web.api.controller;

import com.mcworkshop.dongjing.domain.Right;
import com.mcworkshop.dongjing.domain.Role;
import com.mcworkshop.dongjing.exception.ObjectNotFoundException;
import com.mcworkshop.dongjing.service.RoleService;
import com.mcworkshop.dongjing.web.api.resource.IdResource;
import com.mcworkshop.dongjing.web.api.resource.MapResource;
import com.mcworkshop.dongjing.web.api.resource.RoleResource;
import com.mcworkshop.dongjing.web.api.resource.asm.RoleResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by markfredchen on 3/27/15.
 */

@Controller
public class RoleController extends BaseController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/api/roles", method = RequestMethod.POST)
    @ResponseBody
    public IdResource createRole(@RequestBody @Valid RoleResource roleResource) {
        return new IdResource(roleService.createRole(roleResource.toEntity()));
    }

    @RequestMapping(value = "/api/roles/check/name/{roleName}", method = RequestMethod.GET)
    @ResponseBody
    public MapResource checkRoleNameUniqueness(@PathVariable String roleName) {
        return new MapResource("isUnique", roleService.getRoleByName(roleName) == null);
    }

    @RequestMapping(value = "/api/roles/{roleOID}", method = RequestMethod.PUT)
    @ResponseBody
    public IdResource updateRole(@PathVariable UUID roleOID, @RequestBody @Valid RoleResource role) {
        return new IdResource(roleService.updateRole(role.toEntity()));
    }

    @RequestMapping(value = "/api/roles/{roleOID}", method = RequestMethod.GET)
    @ResponseBody
    public RoleResource getRole(@PathVariable String roleOID) {
        Role role = roleService.getRole(UUID.fromString(roleOID));
        if (role == null) {
            throw new ObjectNotFoundException(Role.class, UUID.fromString(roleOID));
        }
        return new RoleResourceAsm().toResource(role);
    }

    @RequestMapping(value = "/api/roles/{roleOID}", method = RequestMethod.DELETE)
    @ResponseBody
    public IdResource deleteRole(@PathVariable UUID roleOID) {
        roleService.deleteRole(roleOID);
        return new IdResource(roleOID);
    }

    @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
    @ResponseBody
    public List<RoleResource> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        List<RoleResource> response = new ArrayList<>();
        RoleResourceAsm asm = new RoleResourceAsm();
        response.addAll(roles.stream().map(asm::toResource).collect(Collectors.toList()));
        return response;
    }

    @RequestMapping(value = "/api/rights", method = RequestMethod.GET)
    @ResponseBody
    public MapResource getAllRights() {
        List<Right> rights = roleService.getAllRights();
        List<String> rightNames = rights.stream().map(Right::getName).collect(Collectors.toList());
        return new MapResource("rights", rightNames);
    }
}
