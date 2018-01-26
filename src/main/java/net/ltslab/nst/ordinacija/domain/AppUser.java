/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import net.ltslab.nst.ordinacija.domain.enums.Role;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "app_user")
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT au FROM AppUser au"),
    @NamedQuery(name = "AppUser.findByUsername", query = "SELECT au FROM AppUser au WHERE au.username = :username"),
    @NamedQuery(name = "AppUser.findByPassword", query = "SELECT au FROM AppUser au WHERE au.password = :password"),
    @NamedQuery(name = "AppUser.findByFirstName", query = "SELECT au FROM AppUser au WHERE au.firstName = :firstName"),
    @NamedQuery(name = "AppUser.findByLastName", query = "SELECT au FROM AppUser au WHERE au.lastName = :lastName")
}) 

public class AppUser implements Serializable {

    private static final long serialVersionUID = 8107371115139601742L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;
    
    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
        name="roles",
        joinColumns=@JoinColumn(name="app_user")
  )
   @Column(name="roles")
    private Set<Role> roles;

    public AppUser(String username, String password, String firstName, String lastName, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;    
    }

    public AppUser() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.username);
        hash = 79 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppUser other = (AppUser) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AppUser{" + "username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", roles=" + roles + '}';
    }
   
    
    
}