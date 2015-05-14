package com.mcworkshop.dongjing.service;

import com.mcworkshop.dongjing.domain.Right;
import com.mcworkshop.dongjing.domain.Role;
import com.mcworkshop.dongjing.exception.ValidationError;
import com.mcworkshop.dongjing.exception.ValidationException;
import com.mcworkshop.dongjing.persistence.repository.RightRepository;
import com.mcworkshop.dongjing.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by markfredchen on 3/27/15.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RightRepository rightRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public UUID createRole(Role role) {
        Set<String> rightNames = role.getRights().stream().map(Right::getName).collect(Collectors.toSet());
        role.setRights(rightRepository.findByNameIn(rightNames));
        role.setRoleOID(UUID.randomUUID());

        try {
            roleRepository.save(role);
            return role.getRoleOID();
        } catch (DataIntegrityViolationException e) {
            throw new ValidationException(Arrays.asList(new ValidationError("name", "unique.violation")));
        }
    }

    @Override
    public UUID updateRole(Role role) {
        Role persisted = roleRepository.findOneByRoleOID(role.getRoleOID());
        persisted.setName(role.getName());
        Set<String> rightNames = role.getRights().stream().map(Right::getName).collect(Collectors.toSet());
        persisted.setRights(rightRepository.findByNameIn(rightNames));
        try {
            roleRepository.save(persisted);
            return persisted.getRoleOID();
        } catch (DataIntegrityViolationException e) {
            throw new ValidationException(Arrays.asList(new ValidationError("name", "unique.violation")));
        }
    }

    @Override
    public Role getRole(UUID roleOID) {
        return roleRepository.findOneByRoleOID(roleOID);
    }

    @Override
    public void deleteRole(UUID roleOID) {
        roleRepository.deleteByRoleOID(roleOID);
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> result = new ArrayList<>();
        Iterable<Role> roles = roleRepository.findAll();
        for (Role role : roles) {
            result.add(role);
        }
        return result;
    }

    @Override
    public List<Right> getAllRights() {
        return rightRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findOneByName(name);
    }


}
