package sde.project.musicService.DTOs;

import lombok.Getter;
import lombok.Setter;
import sde.project.musicService.model.Music;


@Getter
@Setter
public class LoginDTO {
    private String username;
    private String password;

    LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
