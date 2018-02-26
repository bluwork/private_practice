/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import net.ltslab.nst.ordinacija.repository.impl.PatientSearchRepositoryImpl;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author bobanlukic
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PatientSearchRepositoryTest {

    @Autowired
    private PatientSearchRepositoryImpl patientSearchRepository;

    @Test

    public void repositoryTest() throws Exception {

        assertThat(patientSearchRepository.search("Milovan").size() == 1).isEqualTo(true);
        assertThat(patientSearchRepository.search("Boban").size() == 0).isEqualTo(true);

    }
}
