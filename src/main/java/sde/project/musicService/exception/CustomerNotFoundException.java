package sde.project.musicService.exception;

import lombok.Getter;

@Getter
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
