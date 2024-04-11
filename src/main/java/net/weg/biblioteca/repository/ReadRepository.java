package net.weg.biblioteca.repository;

import net.weg.biblioteca.model.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadRepository extends JpaRepository<Reading, Long> {
}

