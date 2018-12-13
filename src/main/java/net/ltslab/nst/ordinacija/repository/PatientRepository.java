/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.enums.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bobanlukic
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

    List<Patient> findByBloodType(BloodType bloodType);

    List<Patient> findByFirstName(String firstName);

    List<Patient> findByFirstNameAndBloodType(String firstName, BloodType bloodType);

    List<Patient> findBySoftDeletedFalse();

    Patient findPatientById(String id);

    void deleteById(String id);

    List<Patient> findByDateAdded(LocalDate date);

}
