package sde.project.musicService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import sde.project.musicService.model.Music;
import sde.project.musicService.service.SequenceGenerator;


@Component
public class MusicListener extends AbstractMongoEventListener<Music> {

    private SequenceGenerator sequenceGenerator;

    @Autowired
    public MusicListener(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Music> event) {
        if (event.getSource().getId()< 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Music.SEQUENCE_NAME));
        }
    }


}