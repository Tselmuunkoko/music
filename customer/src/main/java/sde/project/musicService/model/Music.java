package sde.project.musicService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Music")
public class Music {
    private String name;
    private Customer customer;
    private Date createdAt;
    private Set<Music> music;
}
