/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;



import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author bobanlukic
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CityRepositoryTest {
    

    @Autowired
    CityRepository repo;
    
    
    @Test
    public void cityRepositoryTest() {
        
        assertThat(repo.findAll().get(0).getZipCode()).isEqualTo(11000L);
        
    }
    
}
