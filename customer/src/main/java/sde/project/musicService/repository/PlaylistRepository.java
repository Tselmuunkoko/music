package sde.project.musicService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sde.project.musicService.model.Playlist;

public interface PlaylistRepository extends MongoRepository<Playlist, Integer> { }
