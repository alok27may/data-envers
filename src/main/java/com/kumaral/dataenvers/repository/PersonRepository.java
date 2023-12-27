package com.kumaral.dataenvers.repository;

import com.kumaral.dataenvers.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
