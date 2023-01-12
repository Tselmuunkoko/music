package sde.project.musicService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sde.project.musicService.service.JwtGeneratorInterface;
import sde.project.musicService.exception.CustomerNotFoundException;
import sde.project.musicService.model.Customer;
import sde.project.musicService.repository.CustomerRepository;
import sde.project.musicService.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class CustomerController {
    private CustomerService customerService;
    private JwtGeneratorInterface jwtGenerator;

    @Autowired
    private CustomerRepository repo;

    @Autowired
    public CustomerController(CustomerService customerService, JwtGeneratorInterface jwtGenerator){
        this.customerService=customerService;
        this.jwtGenerator=jwtGenerator;
    }
    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody Customer customer){
        try{
            customerService.saveUser(customer);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Customer customer) {
        try {
            if(customer.getUsername() == null || customer.getPassword() == null) {
                throw new CustomerNotFoundException("UserName or Password is Empty");
            }
            Customer customerData = customerService.getUserByUserNameAndPassword(customer.getUsername(), customer.getPassword());
            if(customerData == null){
                throw new CustomerNotFoundException("UserName or Password is Invalid");
            }
            return new ResponseEntity<>(jwtGenerator.generateToken(customer), HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/addCustomer")
    public String saveCustomer(@RequestBody Customer customer){
        repo.save(customer);
        return "Added Successfully";
    }

    @GetMapping("/findAllCustomers")
    public List<Customer> getCustomers() {
        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        repo.deleteById(id);
        return "Deleted Successfully";
    }
}
