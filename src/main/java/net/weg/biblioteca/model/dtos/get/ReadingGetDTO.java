package net.weg.biblioteca.model.dtos.get;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.weg.biblioteca.model.entity.Book;
import net.weg.biblioteca.model.entity.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReadingGetDTO {

    private Long id;

    private Long userId;
    private Long bookId;
    private LocalDateTime beginningDate;
}
