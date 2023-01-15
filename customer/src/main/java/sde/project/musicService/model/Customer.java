package sde.project.musicService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Customer")
public class Customer {

        @Transient
        public static final String SEQUENCE_NAME = "customer_sequence";

        @Id
        private long id;

        @NonNull
        @Indexed(unique = true)
        private String username;
        private String email;
        private String password;

        @DBRef
        private List<Long> musicIds;
}
