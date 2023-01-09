package sde.project.musicService.service;

import sde.project.musicService.model.Customer;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(Customer customer);
}
