package sde.project.musicService.controller;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sde.project.musicService.DTOs.MusicDTO;
import sde.project.musicService.model.Customer;
import sde.project.musicService.model.Music;
import sde.project.musicService.repository.CustomerRepository;
import sde.project.musicService.repository.MusicRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/music")
public class MusicController {
    @Autowired
    private MusicRepository repo;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public MusicController() {
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestAttribute("claims") Claims claims,
                                    @RequestHeader(name="Authorization") String token,
                                    @RequestBody MusicDTO dto) {
        try {
            Music music = repo.save(dto.toModel());
            return new ResponseEntity<>(music, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/share/{id}")
    public ResponseEntity<?> shareMusic(@PathVariable long id) {
        try {
            Music music = repo.findById(id);
            music.setIsGlobal(true);
            repo.save(music);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/musics")
    public List<Music> getMusics() {
        return repo.findAll();
    }
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }
}
