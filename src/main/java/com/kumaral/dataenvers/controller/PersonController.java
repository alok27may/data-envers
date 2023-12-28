package com.kumaral.dataenvers.controller;

import com.kumaral.dataenvers.entity.Person;
import com.kumaral.dataenvers.repository.PersonAuditRepository;
import com.kumaral.dataenvers.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;
    private PersonAuditRepository personAuditRepository;


    @GetMapping(value = "/add")
    public boolean addPerson(@RequestParam String name
            , @RequestParam Double salary, @RequestParam String city) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Person person = new Person();
        person.setName(name);
        person.setSalary(salary);
        person.setCity(city);

        personRepository.save(person);

        return true;
    }

    @GetMapping(value = "/update")
    public boolean addPerson(@RequestParam Long id, @RequestParam String name
            , @RequestParam Double salary, @RequestParam String city) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setSalary(salary);
        person.setCity(city);

        personRepository.save(person);

        return true;
    }



    @GetMapping(value = "findByRevision")
    public Person getPersonByRevision(@RequestParam Long revisionId) {
        return personAuditRepository.getPersonByRevisionId(revisionId);
    }

}
