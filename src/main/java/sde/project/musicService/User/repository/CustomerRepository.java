package sde.project.musicService.User.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import sde.project.musicService.User.model.Customer;


public interface CustomerRepository  extends MongoRepository<Customer, Integer> {

    public Customer findByUsernameAndPassword(String username, String password);
}
