package org.aaak.proj.repository;

import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.entity.db.PlanetDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepo extends CrudRepository<PlanetDB, Long> {
    PlanetDB findByResidents(@Param("id") PeopleDB peopleDB);

}
