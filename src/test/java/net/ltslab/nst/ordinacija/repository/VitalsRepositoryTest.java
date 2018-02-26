/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.Vitals;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import net.ltslab.nst.ordinacija.repository.PatientRepository;
import net.ltslab.nst.ordinacija.repository.VitalsRepository;

/**
 *
 * @author bobanlukic
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
public class VitalsRepositoryTest {

    @Autowired
    private VitalsRepository vitalsRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test

    public void repositoryTest() throws Exception {

        List<Vitals> patientVitals = vitalsRepository.findByPatientId(12345678L);

        assertThat(patientVitals.get(0).getBodyTemp()).isEqualTo(36.8f);
        assertThat(patientVitals.get(0).getHeight()).isEqualTo(192);
        assertThat(patientVitals.get(0).getMass()).isEqualTo(84);

        Patient patientOne = patientRepository.getOne(12345678L);

        Vitals oneVitals = new Vitals(LocalDate.now(), 80, 120, 36.5f, 70, 192, 91);

        oneVitals.setPatient(patientOne);
        vitalsRepository.saveAndFlush(oneVitals);

        patientVitals = vitalsRepository.findByPatientId(12345678L);

        assertThat(patientVitals.get(2).getBodyTemp()).isEqualTo(36.5f);
        assertThat(patientVitals.get(2).getHeight()).isEqualTo(192);
        assertThat(patientVitals.get(2).getMass()).isEqualTo(91);

//
//        
//        
//       
//        
//        
//        
//       
    }
}
