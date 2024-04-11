package net.weg.biblioteca.model.dtos.get;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.biblioteca.model.Status;
import net.weg.biblioteca.model.entity.Book;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CopyGetDTO {
    private Long id;
    private Status status;
    private LocalDateTime aquirement;
    private Long bookId;
}
