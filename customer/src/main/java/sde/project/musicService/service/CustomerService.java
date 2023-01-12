package sde.project.musicService.service;

import org.springframework.stereotype.Service;
import sde.project.musicService.exception.CustomerNotFoundException;
import sde.project.musicService.model.Customer;

@Service
public interface CustomerService {
    public void saveUser(Customer customer);
    public Customer getUserByUserNameAndPassword(String username, String password) throws CustomerNotFoundException;
}
