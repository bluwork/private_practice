/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import java.time.LocalDate;
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

        List<Vitals> patientVitals = vitalsRepository.findByPatientId("12345678");

        assertThat(patientVitals.get(0).getBodyTemp()).isEqualTo(36.8f);
        assertThat(patientVitals.get(0).getHeight()).isEqualTo(192);
        assertThat(patientVitals.get(0).getMass()).isEqualTo(84);

        Patient patientOne = patientRepository.getOne("12345678");

        Vitals v = new Vitals();
        v.setMeasuringDate(LocalDate.now());
        v.setDiastolicBP(80);
        v.setSystolicBP(120);
        v.setBodyTemp(36.5f);
        v.setHeartRate(70);
        v.setHeight(192);
        v.setMass(91);

        v.setDiastolicBP(Integer.MIN_VALUE);
        v.setPatient(patientOne);
        vitalsRepository.saveAndFlush(v);

        patientVitals = vitalsRepository.findByPatientId("12345678");

        assertThat(patientVitals.get(2).getBodyTemp()).isEqualTo(36.5f);
        assertThat(patientVitals.get(2).getHeight()).isEqualTo(192);
        assertThat(patientVitals.get(2).getMass()).isEqualTo(91);
    }
}
