/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import net.ltslab.nst.ordinacija.domain.enums.Role;

/**
 *
 * @author bobanlukic
 */
public class AppUserDto implements Serializable {

    private static final long serialVersionUID = -277530629373278448L;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

    public AppUserDto() {

    }

    public AppUserDto(String username, String password, String firstName, String lastName, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
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

    public Set<Role> getRoles() {
        if (roles == null) {
            roles = new HashSet<>();
        }
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        getRoles().add(role);
    }

    public void removeRole(Role role) {
        if (getRoles().contains(role)) {
            getRoles().remove(role);
        }
    }

}
