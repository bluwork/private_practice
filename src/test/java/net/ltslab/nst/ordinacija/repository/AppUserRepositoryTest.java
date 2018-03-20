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
        assertThat(user.getPassword()).isEqualTo("$2y$10$nUrl76SCUWtdzvBT/olxb.pxYgrbQAFED6iMKZMhrBQ8yp0sZn/5q");
        assertThat(user.getFirstName()).isEqualTo("Glavni");
        assertThat(user.getLastName()).isEqualTo("Administrator");

        AppUser badCredentials = appUserRepository.findByUsername("abcd");
        assertThat(badCredentials).isEqualTo(null);

    }
}
