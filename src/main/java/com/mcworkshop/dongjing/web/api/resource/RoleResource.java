package com.mcworkshop.dongjing.web.api.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mcworkshop.dongjing.domain.Right;
import com.mcworkshop.dongjing.domain.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by markfredchen on 3/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"roleOID", "name", "rights"})
public class RoleResource extends BaseResource {
    private String roleOID;
    @NotNull
    private String name;
    @Size(min = 1)
    @NotNull
    private Set<String> rights;

    public String getRoleOID() {
        return roleOID;
    }

    public void setRoleOID(String roleOID) {
        this.roleOID = roleOID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getRights() {
        return rights;
    }

    public void setRights(Set<String> rights) {
        this.rights = rights;
    }

    @Override
    public Role toEntity() {
        Role role = new Role();
        if (roleOID != null) {
            role.setRoleOID(UUID.fromString(roleOID));
        }
        role.setName(name);
        if (rights != null) {
            role.setRights(rights.stream().map(Right::new).collect(Collectors.toSet()));
        }
        return role;
    }
}
