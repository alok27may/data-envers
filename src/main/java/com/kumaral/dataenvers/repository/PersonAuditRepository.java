package com.kumaral.dataenvers.repository;

import com.kumaral.dataenvers.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonAuditRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person getPersonByRevisionId(final Long revisionId) {
        List<Person> personList = new ArrayList<>();
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        AuditQuery auditQuery = auditReader.createQuery().forEntitiesModifiedAtRevision(Person.class, revisionId);
        return (Person) auditQuery.getSingleResult();
    }
}
