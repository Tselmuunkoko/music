package sde.project.musicService.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import sde.project.musicService.model.Customer;


public interface CustomerRepository  extends MongoRepository<Customer, Integer> {

    public Customer findByUsernameAndPassword(String username, String password);
    public Customer findByUsername(String username);
}
