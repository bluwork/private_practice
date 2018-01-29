/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dao;

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
public class PatientDaoTest {


    @Autowired
    private PatientDao patientDao;

    @Test
   
    public void repositoryTest() throws Exception {

        // Test findAll()
        assertThat(patientDao.findAll().size()).isEqualTo(4);
        
        // Test findById
        Patient patientOne = patientDao.findOne(1L);
        
        assertThat(patientOne.getFirstName()).isEqualTo("Milovan");
        assertThat(patientOne.getGender()).isEqualTo(Gender.MALE);
      
        // Test save - update
        patientOne.setGender(Gender.FEMALE);
        patientDao.save(patientOne);
        assertThat(patientDao.findOne(1L).getGender()).isEqualTo(Gender.FEMALE);
        
        // Test delete
        patientDao.delete(2L);
        for (Patient p : patientDao.findAll()) {
            assertThat(p.getId()).isNotEqualTo(2L);
        }
      
    }
}
