/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.repository.PatientSearchRepository;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bobanlukic
 */
@Repository
@Transactional
public class PatientSearchRepositoryImpl implements PatientSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Patient> search(String text) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Patient.class).get();

      
        
                
        Query query = queryBuilder
                .keyword()
                .fuzzy()
                .onFields("firstName", "lastName")
                .matching(text)
                .createQuery();

        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Patient.class);

        // execute search
        List<Patient> patients = null;
        try {
            patients = jpaQuery.getResultList();
        } catch (NoResultException nre) {

        }

        return patients;

    }

}
