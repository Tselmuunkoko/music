package sde.project.musicService.model;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Music")
public class Music {

    @Transient
    public static final String SEQUENCE_NAME = "music_sequence";

    @Id
    private long id;
    private String name;
    private String customerId;
    private Boolean isGlobal;
}
