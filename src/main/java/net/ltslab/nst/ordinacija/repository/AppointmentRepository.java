/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;
import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bobanlukic
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

    public List<Appointment> findByDateOrderByTimeAscPartAsc(LocalDate date);

    public List<Appointment> findByDoctorAndDateOrderByTimeAscPartAsc(AppUser currentDoctor, LocalDate date);
    
}
