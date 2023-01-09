package sde.project.musicService.User;

import sde.project.musicService.User.model.Customer;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(Customer customer);
}
