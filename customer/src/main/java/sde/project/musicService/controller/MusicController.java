package sde.project.musicService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sde.project.musicService.model.Music;
import sde.project.musicService.repository.MusicRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/music")
public class MusicController {
    private MusicRepository repo;
    @Autowired
    public MusicController() {}
    @PostMapping("/share")
    public ResponseEntity<?> shareMusic(@RequestBody Music music) {
        try {
            return new ResponseEntity<>(music, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/musics")
    public List<Music> getMusics() {
        return repo.findAll();
    }
}
