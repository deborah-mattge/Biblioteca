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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime registration = LocalDateTime.now();
    @OneToMany(mappedBy = "user")
    private Collection<Reservation> reservations;
    @OneToMany(mappedBy = "user")
    private Collection<Reading> readings;

}
