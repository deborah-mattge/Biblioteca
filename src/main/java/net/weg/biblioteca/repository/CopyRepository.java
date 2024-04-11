package net.weg.biblioteca.repository;

import net.weg.biblioteca.model.entity.Book;
import net.weg.biblioteca.model.entity.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {
}

