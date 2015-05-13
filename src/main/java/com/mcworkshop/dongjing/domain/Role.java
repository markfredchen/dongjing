package com.mcworkshop.dongjing.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

/**
 * Created by markfredchen on 4/10/15.
 */
@Entity
@Table(name = "T_ROLE")
public class Role extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleID;

    @NotNull
    private UUID roleOID;

    @NotNull
    @Size(max = 50)
    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "T_ROLE_RIGHT",
            joinColumns = @JoinColumn(name = "roleID", referencedColumnName = "roleID"),
            inverseJoinColumns = @JoinColumn(name = "rightID", referencedColumnName = "rightID")
    )
    private Set<Right> rights;

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public UUID getRoleOID() {
        return roleOID;
    }

    public void setRoleOID(UUID roleOID) {
        this.roleOID = roleOID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Right> getRights() {
        return rights;
    }

    public void setRights(Set<Right> rights) {
        this.rights = rights;
    }
}
