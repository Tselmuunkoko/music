package sde.project.musicService.service;

import io.jsonwebtoken.JwtParser;
import sde.project.musicService.model.Customer;

import java.util.Base64;
import java.util.Map;

public class JwtDecoder {
    public static String decode(String token) {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String header = new String(decoder.decode(chunks[0]));
        String body = new String(decoder.decode(chunks[1]));
        return body;
    }
}
