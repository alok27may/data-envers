package com.kumaral.dataenvers.controller;

import com.kumaral.dataenvers.entity.Person;
import com.kumaral.dataenvers.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired private PersonRepository personRepository;


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


}
