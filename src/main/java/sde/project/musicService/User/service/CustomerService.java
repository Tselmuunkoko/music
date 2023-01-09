package sde.project.musicService.User.service;

import org.springframework.stereotype.Service;
import sde.project.musicService.User.exception.CustomerNotFoundException;
import sde.project.musicService.User.model.Customer;

@Service
public interface CustomerService {
    public void saveUser(Customer customer);
    public Customer getUserByUserNameAndPassword(String username, String password) throws CustomerNotFoundException;
}
