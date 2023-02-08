package org.aaak.proj.repository;

import org.aaak.proj.entity.db.PeopleDB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PeopleRepo extends CrudRepository<PeopleDB, Long> {
    List<PeopleDB> findAll();
}
