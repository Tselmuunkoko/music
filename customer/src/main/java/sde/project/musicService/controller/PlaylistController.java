package sde.project.musicService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sde.project.musicService.model.Music;
import sde.project.musicService.model.Playlist;
import sde.project.musicService.repository.PlaylistRepository;

@RestController
@RequestMapping("api/v1/playlist")
public class PlaylistController {
    private PlaylistRepository repo;

    @Autowired
    public PlaylistController() {}

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Playlist playlist) {
        try {
            repo.save(playlist);
            return new ResponseEntity<>(playlist, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
