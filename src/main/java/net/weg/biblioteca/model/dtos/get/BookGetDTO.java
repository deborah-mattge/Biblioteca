package net.weg.biblioteca.model.dtos.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookGetDTO {
    private Long id;
    private String title;
    private String autor;
    private String genre;
    private Integer publishYear;
}
