package sde.project.musicService.service;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

public class ShazamApiService {
    private final static String shazam_uri = "https://shazam.p.rapidapi.com";
    public String search(String audio) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("x-rapidapi-host", "shazam.p.rapidapi.com");
        headers.set("x-rapidapi-key", "c07d6c0b9bmsh3fdc2ab8d9ca0afp1a368ejsn5d6c5156b2d2");
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(shazam_uri+"/search")
                .queryParam("term", "Bios")
                .encode()
                .toUriString();

        HttpEntity request = new HttpEntity(headers);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> entity =  rest.exchange(urlTemplate, HttpMethod.GET, request, String.class);
        return entity.getBody();
    }
}