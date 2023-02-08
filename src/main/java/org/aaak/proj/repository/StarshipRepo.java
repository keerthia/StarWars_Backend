package org.aaak.proj.repository;

import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.entity.db.StarshipsDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StarshipRepo extends CrudRepository<StarshipsDB, Long> {
    List<StarshipsDB> findByPilots(@Param("id") PeopleDB peopleDB);
}
