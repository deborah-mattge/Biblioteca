package net.weg.biblioteca.repository;

import net.weg.biblioteca.model.entity.Book;
import net.weg.biblioteca.model.entity.Reservation;
import net.weg.biblioteca.model.entity.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}

