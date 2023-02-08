package org.aaak.proj.repository;

import org.aaak.proj.entity.db.Film;
import org.aaak.proj.entity.db.PeopleDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film, Long> {


    List<Film> findByCharacters(@Param("id") PeopleDB peopleDB);


}
