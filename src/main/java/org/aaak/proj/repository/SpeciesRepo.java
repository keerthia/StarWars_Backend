package org.aaak.proj.repository;

import org.aaak.proj.entity.db.SpeciesDB;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepo extends CrudRepository<SpeciesDB, Long> {
}
