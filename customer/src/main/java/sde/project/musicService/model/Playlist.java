package sde.project.musicService.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Playlist")
public class Playlist {
    private String name;
    private Customer customer;
}
