/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dao;


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

/**
 *
 * @author bobanlukic
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
public class VitalsDaoTest {
    
    @Autowired
    private VitalsDao vitalsDao;
    
    @Autowired 
    private PatientDao patientDao;
    
    @Test
   
    public void repositoryTest() throws Exception {

        
        
        
        List<Vitals> patientVitals = vitalsDao.findByPatientId(1L);
       
        
        assertThat(patientVitals.get(0).getBodyTemp()).isEqualTo(36.8f);
        assertThat(patientVitals.get(0).getHeight()).isEqualTo(192);
        assertThat(patientVitals.get(0).getMass()).isEqualTo(84);
        
        
        Patient patientOne = patientDao.getOne(1L);
        
        Vitals oneVitals = new Vitals (new Date(System.currentTimeMillis()), 80, 120, 36.5f, 70, 192, 91);
        
        patientOne.addVitals(oneVitals);
        
        patientDao.saveAndFlush(patientOne);
        
        
        patientVitals = vitalsDao.findByPatientId(1L);
        
        
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
