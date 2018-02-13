/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import net.ltslab.nst.ordinacija.repository.AppUserRepository;

/**
 *
 * @author bobanlukic
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
public class AppUserRepositoryTest {
   
    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void repositoryTest() throws Exception {
        
            
        AppUser user = appUserRepository.findByUsernameAndActiveTrue("admin");
        
        assertThat(user.getUsername()).isEqualTo("admin");
        assertThat(user.getPassword()).isEqualTo("Adm1n");
        assertThat(user.getFirstName()).isEqualTo("Boban");
        assertThat(user.getLastName()).isEqualTo("Lukic");
        
        
        AppUser badCredentials = appUserRepository.findByUsername("abcd");
        assertThat(badCredentials).isEqualTo(null);
          
        List<AppUser> allUsers = appUserRepository.findAll();
        assertThat(allUsers.get(1).getPassword()).isEqualTo("jova123");
        
        List<AppUser> activeUsers = appUserRepository.findByActiveTrue();
        assertThat(activeUsers.size() >= 7).isEqualTo(true);
        
    }
}
