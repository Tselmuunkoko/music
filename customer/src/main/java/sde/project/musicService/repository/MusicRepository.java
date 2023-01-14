package sde.project.musicService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sde.project.musicService.model.Music;

public interface MusicRepository  extends MongoRepository<Music, Integer> {
}
