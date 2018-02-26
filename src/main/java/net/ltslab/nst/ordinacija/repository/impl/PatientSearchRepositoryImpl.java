/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
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

// Spring will inject here the entity manager object
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * A basic search for Patient. The search is done by exact match per
     * keywords on fields firstName, lastName, middleName, email or phone
     *
     * @param text The query text.
     */
    public List search(String text) {

        // get the full text entity manager
        FullTextEntityManager fullTextEntityManager
                = Search.
                        getFullTextEntityManager(entityManager);

        // create the query using Hibernate Search query DSL
        QueryBuilder queryBuilder
                = fullTextEntityManager.getSearchFactory()
                        .buildQueryBuilder().forEntity(Patient.class).get();

        // a very basic query by keywords - Lucene query, now jpa query
        Query query
                = queryBuilder
                        .keyword()
                        .onFields("firstName", "lastName", "contactInfo.email", "contactInfo.phone")
                        .matching(text)
                        .createQuery();

        // wrap Lucene query in an Hibernate Query object
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Patient.class);

        // execute search and return results (sorted by relevance as default)
        @SuppressWarnings("unchecked")
        List results = jpaQuery.getResultList();

        return results;
    }

}
