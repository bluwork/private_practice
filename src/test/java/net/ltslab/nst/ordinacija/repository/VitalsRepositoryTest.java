/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.Vitals;
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
public class VitalsRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VitalsRepository repository;

    @Autowired
    private PatientRepository patientRepository;
    
    
    @Test
   
    public void repositoryTest() throws Exception {
        
       
        
        Patient one = new Patient ();
        Patient two = new Patient ();
        Patient three = new Patient ();
        
        Vitals oneVitals = new Vitals (one, new Date(System.currentTimeMillis()), 80, 120, 36.8f, 70, 190, 90);
        Vitals twoVitals = new Vitals (two, new Date(System.currentTimeMillis()), 80, 120, 36.3f, 70, 180, 85);
        Vitals threeVitals = new Vitals (three, new Date(System.currentTimeMillis()), 80, 120, 36.5f, 70, 170, 80);
        
        one.addVitals(oneVitals);
        two.addVitals(twoVitals);
        three.addVitals(threeVitals);
        
        patientRepository.save(one);
        patientRepository.save(two);
        patientRepository.save(three);
        
        
       
        
        
        
        List<Vitals> patOneVitals = repository.findByPatientId(one.getId());
        
        assertThat(patOneVitals.get(0).getBodyTemp()).isEqualTo(36.8f);
        assertThat(patOneVitals.get(0).getHeight()).isEqualTo(190);
        
        
        List<Vitals> patThreeVitals = repository.findByPatientId(three.getId());
        
        assertThat(patThreeVitals.get(0).getBodyTemp()).isEqualTo(36.5f);
        assertThat(patThreeVitals.get(0).getHeight()).isEqualTo(170);
      
      
    }
}
