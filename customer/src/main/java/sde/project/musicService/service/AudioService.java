package sde.project.musicService.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AudioService {
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://127.0.0.1:8000";

    public AudioService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<?> detect(MultiValueMap<String, String> params) {
        HttpHeaders headers = new HttpHeaders(params);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = this.restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                request,
                String.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response;
        } else {
            return null;
        }
    }
}
