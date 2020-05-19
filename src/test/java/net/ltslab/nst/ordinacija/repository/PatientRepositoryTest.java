/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.enums.Gender;
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
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void repositoryTest() throws Exception {

        // Test findById
        Patient patientOne = patientRepository.getOne("12345678");

        assertThat(patientOne.getFirstName()).isEqualTo("Milovan");
        assertThat(patientOne.getGender()).isEqualTo(Gender.MALE);

        // Test save - update
        patientOne.setGender(Gender.FEMALE);
        patientRepository.save(patientOne);
        assertThat(patientRepository.getOne("12345678").getGender()).isEqualTo(Gender.FEMALE);

        // Test delete
        patientRepository.deleteById("22345678");
        patientRepository.findAll().forEach((p) -> {
            assertThat(p.getId()).isNotEqualTo(22345678L);
        });

    }
}
