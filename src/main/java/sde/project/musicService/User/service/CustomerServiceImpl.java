package sde.project.musicService.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sde.project.musicService.User.exception.CustomerNotFoundException;
import sde.project.musicService.User.model.Customer;
import sde.project.musicService.User.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public void saveUser(Customer customer) {
        customerRepository.save(customer);
    }
    @Override
    public Customer getUserByUserNameAndPassword(String name, String password) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByUsernameAndPassword(name, password);
        if(customer == null){
            throw new CustomerNotFoundException("Invalid id and password");
        }
        return customer;
    }
}
