package com.zrariom.copsboot.user;

import com.sun.istack.NotNull;
import com.zrariom.copsboot.orm.jpa.AbstractEntity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "copsboot_user")
public class User extends AbstractEntity<UserId> {

    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    protected User() {
    }

    public User(UserId id, String email, String password, Set<UserRole> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }
}
