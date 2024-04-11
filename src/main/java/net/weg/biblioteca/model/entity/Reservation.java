package net.weg.biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reservation {
    @EmbeddedId
    private ReservationId reservationId;
    @ManyToOne
    @MapsId("userId")
    private User user;
    @ManyToOne
    @MapsId("copyId")
    private Copy copy;
    private LocalDateTime reservationDate = LocalDateTime.now();
}
