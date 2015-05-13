package com.mcworkshop.dongjing.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Created by markfredchen on 4/11/15.
 */
@Entity
@Table(name = "T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    @NotNull
    private UUID userOID;

    @NotNull
    @Size(max=50)
    @Column(unique = true, updatable = false)
    private String username;

    @NotNull
    @Size(max=255)
    @Column(unique = true, updatable = false)
    private String password;

    @Size(max=100)
    @Column(unique = true)
    private String email;

    @Size(max=50)
    private String firstName;

    @Size(max=50)
    private String lastName;

    @Size(max=50)
    private String phone;

    @Size(max=50)
    private String cellPhone;

    @Size(max=50)
    private String title;

    @Size(max=50)
    private String department;

    private boolean isActive;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public UUID getUserOID() {
        return userOID;
    }

    public void setUserOID(UUID userOID) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
