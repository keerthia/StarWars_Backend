package org.aaak.proj.repository;

import org.aaak.proj.entity.db.aaakForeignTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignTableMapping extends JpaRepository<aaakForeignTable, Long> {
}
