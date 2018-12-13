/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import net.ltslab.nst.ordinacija.domain.AppUser;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
        assertThat(user.getPassword()).isEqualTo("$2a$05$KevIcBN8FPAyx4ImSKM2punbEjNDQeWGopkQXCX8fkr2Y1uMaWNRC");
        assertThat(user.getFirstName()).isEqualTo("Glavni");
        assertThat(user.getLastName()).isEqualTo("Administrator");

        AppUser badCredentials = appUserRepository.findByUsername("abcd");
        assertThat(badCredentials).isEqualTo(null);

    }
}
