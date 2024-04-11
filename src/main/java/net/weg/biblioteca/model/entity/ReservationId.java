package net.weg.biblioteca.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationId implements Serializable {
    Long userId;
    Long copyId;
}
