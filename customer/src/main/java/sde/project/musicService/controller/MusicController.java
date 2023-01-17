package sde.project.musicService.controller;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import sde.project.musicService.DTOs.MusicDTO;
import sde.project.musicService.model.Customer;
import sde.project.musicService.model.Music;
import sde.project.musicService.repository.CustomerRepository;
import sde.project.musicService.repository.MusicRepository;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/music")
public class MusicController {
    @Autowired
    private MusicRepository repo;

    @Autowired
    private CustomerRepository customerRepository;

    @Value("${music.api.host}")
    private String baseUrl;

    @Autowired
    public MusicController() {
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(
                                    @RequestBody MusicDTO dto) {
        try {
//            Customer c = customerRepository.findByUsername((String) claims.get("sub"));
            Music music = repo.save(dto.toModel());
//            music.setCustomerId(c.getId());
//            repo.save(music);
            return new ResponseEntity<>(music, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<?> retrieve(@PathVariable long id) {
        try {
            return new ResponseEntity<>(repo.findById(id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
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
    @PostMapping("/detect")
    public String detect(@RequestBody String audio) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.valueOf("application/json"));
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .encode()
                .toUriString();
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("data", audio);
        HttpEntity request = new HttpEntity(body, headers);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> entity =  rest.exchange(urlTemplate, HttpMethod.POST, request, String.class);
        return entity.getBody();
    }

    @GetMapping("/top")
    public ResponseEntity<?> top() {
        try {
            return new ResponseEntity<>(repo.findByIsGlobalIsTrue(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
