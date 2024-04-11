package net.weg.biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String autor;
    private String genre;
    private Integer publishYear;
    @OneToMany
    private Collection<Reservation> reservations;
    @OneToMany(mappedBy = "book")
    private Collection<Reading> readings;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Copy> copies;

}
