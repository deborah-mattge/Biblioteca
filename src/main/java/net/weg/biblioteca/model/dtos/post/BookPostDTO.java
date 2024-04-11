package net.weg.biblioteca.model.dtos.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookPostDTO {
    private String title;
    private String autor;
    private String genre;
    private Integer publishYear;
}
