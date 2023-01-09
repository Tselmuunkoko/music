package sde.project.musicService.User.exception;

import lombok.Getter;

@Getter
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
