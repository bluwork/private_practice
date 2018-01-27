/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import java.util.ArrayList;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.enums.BloodType;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author bobanlukic
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PatientRepository repository;

    @Test
   
    public void repositoryTest() throws Exception {
        
        entityManager.persist(new Patient ("Jovan", "Petar", "Jovic", null, null,BloodType.AB_NEGATIVE, null, null));
        entityManager.persist(new Patient ("Dragan", "Dragomir", "Dragic", null, null,BloodType.O_POSITIVE, null, null));
        entityManager.persist(new Patient ("Jovan", "Marko", "Jovic", null, null,BloodType.B_POSITIVE, null, null));
        
        entityManager.flush();
        
        Patient patient = repository.findOne(1L);
        assertThat(patient.getLastName()).isEqualTo("Jovic");
        assertThat(patient.getBloodType()).isEqualTo(BloodType.AB_NEGATIVE);
        
        List<Patient> patients =  repository.findAll();
        assertThat(patients.get(0).getMiddleName()).isEqualTo("Petar");
        
        
        patients = repository.findByBloodType(BloodType.AB_NEGATIVE);
        assertThat(patients.get(0).getMiddleName()).isEqualTo("Petar");
           
        patients = repository.findByFirstName("Jovan");
        assertThat(patients.size()).isEqualTo(2);
        
        patients = repository.findByFirstNameAndBloodType("Jovan", BloodType.B_POSITIVE);
        assertThat(patients.get(0).getMiddleName()).isEqualTo("Marko");
      
    }
}
