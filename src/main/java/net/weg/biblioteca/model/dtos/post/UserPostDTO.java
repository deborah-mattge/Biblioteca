package net.weg.biblioteca.model.dtos.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPostDTO {
    private String name;
    private String email;
    private String password;
}
