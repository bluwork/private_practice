/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import net.ltslab.nst.ordinacija.domain.enums.Role;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "app_user")
@Data
public class AppUser implements Serializable {

    private static final long serialVersionUID = 8107371115139601742L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Size(max = 30)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 30)
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private boolean active = true;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "roles",
            joinColumns = @JoinColumn(name = "app_user")
    )
    @Column(name = "roles")
    private Set<Role> roles;

}
