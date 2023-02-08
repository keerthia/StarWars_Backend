package org.aaak.proj.repository;

import org.aaak.proj.entity.db.VehicleDB;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepo extends CrudRepository<VehicleDB, Long> {
}
