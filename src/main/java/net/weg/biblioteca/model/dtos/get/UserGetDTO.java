package net.weg.biblioteca.model.dtos.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGetDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime registration;
}
