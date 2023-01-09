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
@Document(collection = "Playlist")
public class Playlist {
    private String name;
    private Customer customer;
    private Date createdAt;
    private Set<Music> music;
    // search with lyrics, music, hum, artist, name, genre,
    // save the history, save the search as playlist.
}
