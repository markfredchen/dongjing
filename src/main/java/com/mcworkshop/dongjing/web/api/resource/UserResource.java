package com.mcworkshop.dongjing.web.api.resource;

import com.mcworkshop.dongjing.domain.Role;
import com.mcworkshop.dongjing.domain.User;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by markfredchen on 5/13/15.
 */
public class UserResource extends BaseResource {

    private String  userOID;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String cellPhone;

    private String phone;

    private String title;

    private String department;

    @NotNull
    private Set<String> roleOIDs;

    public String getUserOID() {
        return userOID;
    }

    public void setUserOID(String userOID) {
        this.userOID = userOID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<String> getRoleOIDs() {
        return roleOIDs;
    }

    public void setRoleOIDs(Set<String> roleOIDs) {
        this.roleOIDs = roleOIDs;
    }

    @Override
    public User toEntity() {
        User user = new User();
        if(userOID != null) {
            user.setUserOID(UUID.fromString(userOID));
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCellPhone(cellPhone);
        user.setPhone(phone);
        user.setTitle(title);
        user.setDepartment(department);
        user.setRoles(roleOIDs.stream().map(roleOID -> {
            Role role = new Role();
            role.setRoleOID(UUID.fromString(roleOID));
            return role;
        }).collect(Collectors.toSet()));
        return user;
    }
}
