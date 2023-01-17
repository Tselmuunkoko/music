package sde.project.musicService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sde.project.musicService.model.Music;
import java.util.List;

public interface MusicRepository  extends MongoRepository<Music, Integer> {
    Music findById(long id);

    void deleteById(long id);

    List<Music> findByIsGlobalIsTrue();
}
