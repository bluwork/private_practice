/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.enums.Role;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author bobanlukic
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AppUserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppUserRepository repository;

    @Test
    @Timed(millis = 500)
    public void repositoryTest() throws Exception {
        Set<Role> testRoles = new HashSet<>();
        testRoles.add(Role.NURSE);
        
        entityManager.persist(new AppUser("Dusko Dugousko", "Pass123", "Dusko", "Dugousko", testRoles));
        
        AppUser user = repository.findByUsername("Dusko Dugousko");
        
        
        assertThat(user.getUsername()).isEqualTo("Dusko Dugousko");
        assertThat(user.getPassword()).isEqualTo("Pass123");
        assertThat(user.getFirstName()).isEqualTo("Dusko");
        assertThat(user.getLastName()).isEqualTo("Dugousko");
        assertThat(user.getRoles()).isEqualTo(testRoles);
        
        AppUser badCredentials = repository.findByUsername("abcd");
        assertThat(badCredentials).isEqualTo(null);
          
        List<AppUser> allUsers = repository.findAll();
        assertThat(allUsers.get(0)).isEqualTo(user);
          
    }
}
