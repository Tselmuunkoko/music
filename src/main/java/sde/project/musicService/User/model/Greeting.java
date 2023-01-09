package sde.project.musicService.User.model;

public class Greeting {
    private final long id;
    private final String content;

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }
}
