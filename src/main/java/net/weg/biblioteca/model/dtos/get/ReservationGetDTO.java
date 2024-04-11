package net.weg.biblioteca.model.dtos.get;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.biblioteca.model.entity.Copy;
import net.weg.biblioteca.model.entity.ReservationId;
import net.weg.biblioteca.model.entity.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationGetDTO {
    private ReservationId reservationId;
    private LocalDateTime reservationDate;
}
