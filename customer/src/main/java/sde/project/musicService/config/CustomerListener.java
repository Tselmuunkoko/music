package sde.project.musicService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import sde.project.musicService.model.Customer;
import sde.project.musicService.service.SequenceGenerator;

public class CustomerListener  extends AbstractMongoEventListener<Customer> {
    private SequenceGenerator sequenceGenerator;

    @Autowired
    public CustomerListener(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Customer> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Customer.SEQUENCE_NAME));
        }
    }
}
