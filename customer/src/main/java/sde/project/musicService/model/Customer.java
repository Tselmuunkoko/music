package sde.project.musicService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Customer")
public class Customer {
        private String username;
        private String email;
        private String password;
}
