package sde.project.musicService.controller;

import org.springframework.web.bind.annotation.*;
import sde.project.musicService.service.ShazamApiService;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("api/v1/shazam")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final ShazamApiService shazamApiService = new ShazamApiService();

    @GetMapping("/greeting")
    public String greeting(@RequestHeader(name = "Authorization") String headerStr,
                           @RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(headerStr);
        System.out.println(name);
        return  shazamApiService.search();
    }
}
