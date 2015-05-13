package com.mcworkshop.dongjing.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by markfredchen on 4/10/15.
 */
@Entity
@Table(name = "T_RIGHT")
public class Right extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rightID;

    @NotNull
    @Size(max = 50)
    @Column(unique = true)
    private String name;

    public Right() {
    }

    public Right(String name) {
        this.name = name;
    }

    public Long getRightID() {
        return rightID;
    }

    public void setRightID(Long rightID) {
        this.rightID = rightID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
