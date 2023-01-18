package sde.project.musicService.DTOs;

import lombok.Getter;
import lombok.Setter;
import sde.project.musicService.model.Music;

@Getter
@Setter
public class MusicDTO {
    private String name;
    private Boolean isGlobal;

    private String url;

    MusicDTO(String name, Boolean isGlobal) {
        this.name = name;
        this.isGlobal = isGlobal;
        this.url = url;
    }

    public Music toModel() {
        Music music = new Music();
        music.setIsGlobal(isGlobal);
        music.setName(name);
        music.setUrl(url);
        return music;
    }
}
