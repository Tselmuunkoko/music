package sde.project.musicService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "History")
public class History {
    private String name;
    private Customer customer;
    private Date createdAt;
}
