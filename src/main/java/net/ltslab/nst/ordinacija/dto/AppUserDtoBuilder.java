/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.util.Set;
import net.ltslab.nst.ordinacija.domain.enums.Role;

/**
 *
 * @author bobanlukic
 */
public class AppUserDtoBuilder {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles;
    
    public AppUserDtoBuilder() {}
    
    public AppUserDto build() {
        return new AppUserDto(username, password, firstName, lastName, roles);
    }
    
    public AppUserDtoBuilder addUsername(String username) {
        this.username=username;
        return this;
    }
    public AppUserDtoBuilder addPassword(String password) {
        this.password=password;
        return this;
    }
    public AppUserDtoBuilder addFirstName(String firstName) {
        this.firstName=firstName;
        return this;
    }
    public AppUserDtoBuilder addLastName(String lastName) {
        this.lastName=lastName;
        return this;
    }
    public AppUserDtoBuilder addRoles(Set<Role> roles) {
        this.roles=roles;
        return this;
    }
}
